package com.yy.sdk.crashreportbaidu;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ReportInfo implements Serializable {
    public String crashId;
    public String crashType;
    public List<String> fileList = new ArrayList();
    public String history;
    public String nyyData;

    public String serialize() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static Object deserialize(String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
        Object readObject = objectInputStream.readObject();
        objectInputStream.close();
        return readObject;
    }

    public void clearFiles(List<String> list) {
        for (String str : list) {
            if (str != null) {
                File file = new File(str);
                if (!file.getName().endsWith(".syslog") && !file.getName().endsWith(".dmp") && !file.getName().endsWith(".symbol") && !file.getName().endsWith(".txt")) {
                    if (file.getName().contains(this.crashId) && file.exists()) {
                        file.delete();
                    }
                } else if (file.exists()) {
                    file.delete();
                }
            }
        }
    }
}
