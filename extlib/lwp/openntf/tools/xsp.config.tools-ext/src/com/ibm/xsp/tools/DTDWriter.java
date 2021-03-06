 /*
 * � Copyright IBM Corp. 2011, 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.ibm.xsp.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Artur Lebedevas
 *
 */
public class DTDWriter {

    public static void main(String[] args){
        BufferedReader reader = null;
        try {
            File outFile = new File(args[1]);
            reader = new BufferedReader(new FileReader(args[0]));
            String str = null;
            StringBuilder sBuilder = new StringBuilder();
            
            while((str = reader.readLine()) != null) {
                sBuilder.append(str);
                sBuilder.append("\n");
            }

            String result = sBuilder.toString();

            ToolsUtil.writeOut(outFile, result);
            
        } catch (RuntimeException e) {
            System.err.println(DTDWriter.class.getName()+".main(): "+ e.getMessage());
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            System.err.println(DTDWriter.class.getName()+".main(): "+ e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println(DTDWriter.class.getName()+".main() Problem closing stream "+args[0]);
            }
        }
    }

}
