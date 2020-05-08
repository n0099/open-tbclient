package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class cn {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f168a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f168a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f168a.delete(0, this.f168a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f168a.append(cmVar.a + "\t");
        this.f168a.append(cmVar.f167a + "\t" + cmVar.b);
        this.f168a.append("\r\n");
    }
}
