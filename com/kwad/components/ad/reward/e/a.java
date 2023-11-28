package com.kwad.components.ad.reward.e;
/* loaded from: classes10.dex */
public abstract class a implements g {
    @Override // com.kwad.components.ad.reward.e.g
    public int getPriority() {
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
