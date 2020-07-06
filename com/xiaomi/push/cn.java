package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class cn {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f175a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f175a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f175a.delete(0, this.f175a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f175a.append(cmVar.a + "\t");
        this.f175a.append(cmVar.f174a + "\t" + cmVar.b);
        this.f175a.append("\r\n");
    }
}
