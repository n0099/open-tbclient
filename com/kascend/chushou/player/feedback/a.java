package com.kascend.chushou.player.feedback;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a {
    public long b;
    private List<FlingObj> c;
    public FlingObj mQF = new FlingObj();

    public void a() {
        if (this.mQF != null && !h.isEmpty(this.mQF.roomId)) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(this.mQF.copy());
        }
    }

    public void b() {
        if (!h.isEmpty(this.c)) {
            String json = new Gson().toJson(this.c);
            this.c.clear();
            com.kascend.chushou.toolkit.a.a.l("type", "7", "value", json);
        }
    }
}
