package com.squareup.wire;

import com.squareup.javawriter.JavaWriter;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoSchemaParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
interface IO {
    JavaWriter getJavaWriter(String str, String str2, String str3);

    ProtoFile parse(String str);

    /* loaded from: classes.dex */
    public class FileIO implements IO {
        private static final Charset UTF_8 = Charset.forName("UTF8");

        @Override // com.squareup.wire.IO
        public ProtoFile parse(String str) {
            return ProtoSchemaParser.parse(str, new InputStreamReader(new FileInputStream(str), UTF_8));
        }

        @Override // com.squareup.wire.IO
        public JavaWriter getJavaWriter(String str, String str2, String str3) {
            String str4 = String.valueOf(str) + File.separator + str2.replace(".", File.separator);
            if (new File(str4).mkdirs()) {
                System.out.println("Created output directory " + str4);
            }
            String str5 = String.valueOf(str4) + File.separator + str3 + ".java";
            System.out.println("Writing generated code to " + str5);
            return new JavaWriter(new OutputStreamWriter(new FileOutputStream(str5), UTF_8));
        }
    }
}
