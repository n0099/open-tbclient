package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* loaded from: classes12.dex */
class cn {

    /* renamed from: a  reason: collision with root package name */
    private File f4839a;

    /* renamed from: a  reason: collision with other field name */
    private StringBuilder f167a;

    public void a() {
        try {
            FileWriter fileWriter = new FileWriter(this.f4839a, true);
            fileWriter.write(this.f167a.toString());
            fileWriter.flush();
            fileWriter.close();
            this.f167a.delete(0, this.f167a.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(cm cmVar) {
        this.f167a.append(cmVar.f4838a + "\t");
        this.f167a.append(cmVar.f166a + "\t" + cmVar.b);
        this.f167a.append("\r\n");
    }
}
