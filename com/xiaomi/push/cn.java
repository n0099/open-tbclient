package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class cn {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f174a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f174a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f174a.delete(0, this.f174a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f174a.append(cmVar.a + "\t");
        this.f174a.append(cmVar.f173a + "\t" + cmVar.b);
        this.f174a.append("\r\n");
    }
}
