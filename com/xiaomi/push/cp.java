package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes6.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f14218a;

    /* renamed from: a  reason: collision with other field name */
    ct f256a;

    /* renamed from: a  reason: collision with other field name */
    String f257a;

    /* renamed from: b  reason: collision with root package name */
    String f14219b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f257a = str;
        this.f14219b = str2;
        this.f256a = ctVar;
        this.f14218a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f257a, this.f14219b, this.f14218a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f256a != null) {
            this.f256a.a(num, this.f14218a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f256a != null) {
            this.f256a.a(1, this.f14218a);
        }
    }
}
