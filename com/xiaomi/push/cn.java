package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes7.dex */
class cn {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f170a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f170a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f170a.delete(0, this.f170a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f170a.append(cmVar.a + "\t");
        this.f170a.append(cmVar.f169a + "\t" + cmVar.b);
        this.f170a.append("\r\n");
    }
}
