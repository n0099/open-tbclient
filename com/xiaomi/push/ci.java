package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class ci {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f184a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f184a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f184a.delete(0, this.f184a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(ch chVar) {
        this.f184a.append(chVar.a + "\t");
        this.f184a.append(chVar.f183a + "\t" + chVar.b);
        this.f184a.append("\r\n");
    }
}
