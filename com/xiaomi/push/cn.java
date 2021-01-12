package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
class cn {

    /* renamed from: a  reason: collision with root package name */
    private File f13916a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f248a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.f13916a, true);
            fileWriter.write(this.f248a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f248a.delete(0, this.f248a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f248a.append(cmVar.f13914a + "\t");
        this.f248a.append(cmVar.f247a + "\t" + cmVar.f13915b);
        this.f248a.append("\r\n");
    }
}
