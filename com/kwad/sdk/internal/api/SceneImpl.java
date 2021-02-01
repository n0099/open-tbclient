package com.kwad.sdk.internal.api;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SceneImpl implements KsScene, Serializable {
    private static final long serialVersionUID = 93865491903408451L;
    private int action;
    private int adNum;
    private int adStyle;
    public long entryScene;
    private int height;
    private long posId;
    private transient URLPackage urlPackage;
    private int width;

    public SceneImpl() {
        this.adNum = 1;
    }

    public SceneImpl(long j) {
        this.adNum = 1;
        this.posId = j;
        this.entryScene = j;
    }

    public SceneImpl(KsScene ksScene) {
        this.adNum = 1;
        this.posId = ksScene.getPosId();
        this.entryScene = ksScene.getPosId();
        this.adNum = ksScene.getAdNum();
        this.action = ksScene.getAction();
        this.width = ksScene.getWidth();
        this.height = ksScene.getHeight();
        this.adStyle = ksScene.getAdStyle();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        return this.action;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        return this.adNum;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        return this.height;
    }

    public int getPageScene() {
        if (this.urlPackage == null) {
            return 0;
        }
        return this.urlPackage.page;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        return this.posId;
    }

    public URLPackage getUrlPackage() {
        return this.urlPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i) {
        this.action = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i) {
        this.adNum = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i) {
        this.adStyle = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        this.posId = j;
        this.entryScene = j;
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i) {
        this.width = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.posId);
        o.a(jSONObject, "entryScene", this.entryScene);
        o.a(jSONObject, "adNum", this.adNum);
        o.a(jSONObject, "action", this.action);
        o.a(jSONObject, "width", this.width);
        o.a(jSONObject, "height", this.height);
        o.a(jSONObject, "adStyle", this.adStyle);
        o.a(jSONObject, "urlPackage", this.urlPackage);
        return jSONObject;
    }
}
