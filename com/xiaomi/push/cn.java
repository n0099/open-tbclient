package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes9.dex */
class cn {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f171a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f171a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f171a.delete(0, this.f171a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f171a.append(cmVar.a + "\t");
        this.f171a.append(cmVar.f170a + "\t" + cmVar.b);
        this.f171a.append("\r\n");
    }
}
