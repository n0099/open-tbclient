package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
class cn {

    /* renamed from: a  reason: collision with root package name */
    private File f14216a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f249a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.f14216a, true);
            fileWriter.write(this.f249a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f249a.delete(0, this.f249a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f249a.append(cmVar.f14214a + "\t");
        this.f249a.append(cmVar.f248a + "\t" + cmVar.f14215b);
        this.f249a.append("\r\n");
    }
}
