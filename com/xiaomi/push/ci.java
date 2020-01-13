package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
class ci {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f186a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f186a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f186a.delete(0, this.f186a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(ch chVar) {
        this.f186a.append(chVar.a + "\t");
        this.f186a.append(chVar.f185a + "\t" + chVar.b);
        this.f186a.append("\r\n");
    }
}
