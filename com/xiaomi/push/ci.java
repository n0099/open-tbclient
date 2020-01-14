package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes6.dex */
class ci {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f187a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f187a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f187a.delete(0, this.f187a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(ch chVar) {
        this.f187a.append(chVar.a + "\t");
        this.f187a.append(chVar.f186a + "\t" + chVar.b);
        this.f187a.append("\r\n");
    }
}
