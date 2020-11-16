package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes18.dex */
class cn {

    /* renamed from: a  reason: collision with root package name */
    private File f4841a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f172a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.f4841a, true);
            fileWriter.write(this.f172a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f172a.delete(0, this.f172a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f172a.append(cmVar.f4840a + "\t");
        this.f172a.append(cmVar.f171a + "\t" + cmVar.b);
        this.f172a.append("\r\n");
    }
}
