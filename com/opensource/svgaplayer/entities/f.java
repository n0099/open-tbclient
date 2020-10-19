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
/* loaded from: classes15.dex */
public final class f {
    private final List<g> frames;
    private final String imageKey;

    public final String getImageKey() {
        return this.imageKey;
    }

    public final List<g> ejH() {
        return this.frames;
    }

    public f(JSONObject jSONObject) {
        q.n(jSONObject, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.imageKey = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.jz().isEmpty()) && ((SVGAVideoShapeEntity) o.gl(gVar.jz())).ejx() && arrayList.size() > 0) {
                        gVar.gb(((g) o.gm(arrayList)).jz());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.frames = o.g(arrayList);
    }

    public f(SpriteEntity spriteEntity) {
        ArrayList enJ;
        q.n(spriteEntity, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this.imageKey = spriteEntity.imageKey;
        g gVar = null;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            List<FrameEntity> list2 = list;
            ArrayList arrayList = new ArrayList(o.a(list2, 10));
            g gVar2 = gVar;
            for (FrameEntity frameEntity : list2) {
                q.m(frameEntity, AdvanceSetting.NETWORK_TYPE);
                g gVar3 = new g(frameEntity);
                if ((!gVar3.jz().isEmpty()) && ((SVGAVideoShapeEntity) o.gl(gVar3.jz())).ejx() && gVar2 != null) {
                    gVar3.gb(gVar2.jz());
                }
                arrayList.add(gVar3);
                gVar2 = gVar3;
            }
            enJ = arrayList;
        } else {
            enJ = o.enJ();
        }
        this.frames = enJ;
    }
}
