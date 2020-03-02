package com.xiaomi.miui.pushads.sdk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes8.dex */
class g {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f84a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f84a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f84a.delete(0, this.f84a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, long j, int i) {
        this.f84a.append(str + "\t" + j + "\t" + i);
        this.f84a.append("\r\n");
    }
}
