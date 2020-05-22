package com.opensource.svgaplayer.entities;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.o;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONArray;
import org.json.JSONObject;
@h
/* loaded from: classes.dex */
public final class f {
    private final List<g> frames;
    private final String imageKey;

    public final String dGW() {
        return this.imageKey;
    }

    public final List<g> dHu() {
        return this.frames;
    }

    public f(JSONObject jSONObject) {
        q.m(jSONObject, "obj");
        this.imageKey = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.hG().isEmpty()) && ((SVGAVideoShapeEntity) o.fs(gVar.hG())).dHk() && arrayList.size() > 0) {
                        gVar.fi(((g) o.ft(arrayList)).hG());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.frames = o.g(arrayList);
    }

    public f(SpriteEntity spriteEntity) {
        ArrayList dLu;
        q.m(spriteEntity, "obj");
        this.imageKey = spriteEntity.imageKey;
        g gVar = null;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            List<FrameEntity> list2 = list;
            ArrayList arrayList = new ArrayList(o.a(list2, 10));
            g gVar2 = gVar;
            for (FrameEntity frameEntity : list2) {
                q.l((Object) frameEntity, AdvanceSetting.NETWORK_TYPE);
                g gVar3 = new g(frameEntity);
                if ((!gVar3.hG().isEmpty()) && ((SVGAVideoShapeEntity) o.fs(gVar3.hG())).dHk() && gVar2 != null) {
                    gVar3.fi(gVar2.hG());
                }
                arrayList.add(gVar3);
                gVar2 = gVar3;
            }
            dLu = arrayList;
        } else {
            dLu = o.dLu();
        }
        this.frames = dLu;
    }
}
