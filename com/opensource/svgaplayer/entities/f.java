package com.opensource.svgaplayer.entities;

import com.baidu.platform.comapi.map.MapBundleKey;
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
/* loaded from: classes11.dex */
public final class f {
    private final List<g> frames;
    private final String imageKey;

    public final String ebs() {
        return this.imageKey;
    }

    public final List<g> ebQ() {
        return this.frames;
    }

    public f(JSONObject jSONObject) {
        q.m(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.imageKey = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.jx().isEmpty()) && ((SVGAVideoShapeEntity) o.fZ(gVar.jx())).ebG() && arrayList.size() > 0) {
                        gVar.fP(((g) o.ga(arrayList)).jx());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.frames = o.g(arrayList);
    }

    public f(SpriteEntity spriteEntity) {
        ArrayList efR;
        q.m(spriteEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
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
                if ((!gVar3.jx().isEmpty()) && ((SVGAVideoShapeEntity) o.fZ(gVar3.jx())).ebG() && gVar2 != null) {
                    gVar3.fP(gVar2.jx());
                }
                arrayList.add(gVar3);
                gVar2 = gVar3;
            }
            efR = arrayList;
        } else {
            efR = o.efR();
        }
        this.frames = efR;
    }
}
