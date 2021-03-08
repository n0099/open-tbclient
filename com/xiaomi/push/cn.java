package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes5.dex */
class cn {

    /* renamed from: a  reason: collision with root package name */
    private File f8304a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f169a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.f8304a, true);
            fileWriter.write(this.f169a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f169a.delete(0, this.f169a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f169a.append(cmVar.f8303a + "\t");
        this.f169a.append(cmVar.f168a + "\t" + cmVar.b);
        this.f169a.append("\r\n");
    }
}
