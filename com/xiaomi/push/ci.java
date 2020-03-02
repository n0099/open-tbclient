package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class ci {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f183a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f183a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f183a.delete(0, this.f183a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(ch chVar) {
        this.f183a.append(chVar.a + "\t");
        this.f183a.append(chVar.f182a + "\t" + chVar.b);
        this.f183a.append("\r\n");
    }
}
