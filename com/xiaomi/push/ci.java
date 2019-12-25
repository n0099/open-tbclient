package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes5.dex */
class ci {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f188a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f188a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f188a.delete(0, this.f188a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(ch chVar) {
        this.f188a.append(chVar.a + "\t");
        this.f188a.append(chVar.f187a + "\t" + chVar.b);
        this.f188a.append("\r\n");
    }
}
