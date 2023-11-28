package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public final class b implements Comparable<b> {
    public boolean Jq;
    public String ajM;
    public String ajN;
    public long ajO;
    public String ajP;
    public boolean ajQ = false;
    public boolean ajR = true;
    public HashMap<String, String> ajS = new HashMap<>(10);
    public List<String> ajT;
    public List<String> ajU;
    public ClassLoader ajV;
    public String ajs;
    public boolean ajt;
    public String version;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.ajM + "', version='" + this.version + "', downloadUrl='" + this.ajN + "', fileSize=" + this.ajO + ", enable=" + this.Jq + ", md5sum='" + this.ajP + "', onlyWifiDownload=" + this.ajQ + ", onlyWifiRetryDownload=" + this.ajR + ", soMd5s=" + this.ajS + ", hostPackages=" + this.ajT + ", hostInterfaces=" + this.ajU + '}';
    }
}
