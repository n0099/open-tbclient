package com.xiaomi.miui.pushads.sdk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes5.dex */
class g {
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f89a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.a, true);
            fileWriter.write(this.f89a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f89a.delete(0, this.f89a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, long j, int i) {
        this.f89a.append(str + "\t" + j + "\t" + i);
        this.f89a.append("\r\n");
    }
}
