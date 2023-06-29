package com.kwad.sdk.api.model;
/* loaded from: classes10.dex */
public final class a implements IKsAdLabel {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getChannel() {
        return this.g;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final long getCpmBidFloor() {
        return this.h;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getHistoryTitle() {
        return this.f;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPostTitle() {
        return this.e;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getPrevTitle() {
        return this.d;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdAge() {
        return this.a;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final int getThirdGender() {
        return this.b;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final String getThirdInterest() {
        return this.c;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setChannel(String str) {
        this.g = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setCpmBidFloor(long j) {
        this.h = j;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setHistoryTitle(String str) {
        this.f = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPostTitle(String str) {
        this.e = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setPrevTitle(String str) {
        this.d = str;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdAge(int i) {
        this.a = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdGender(int i) {
        this.b = i;
    }

    @Override // com.kwad.sdk.api.model.IKsAdLabel
    public final void setThirdInterest(String str) {
        this.c = str;
    }
}
