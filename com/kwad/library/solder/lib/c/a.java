package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class a implements Comparable<a> {
    public String ajM;
    public boolean qr;
    public String version;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
