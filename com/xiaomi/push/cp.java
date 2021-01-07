package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes6.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f14219a;

    /* renamed from: a  reason: collision with other field name */
    ct f257a;

    /* renamed from: a  reason: collision with other field name */
    String f258a;

    /* renamed from: b  reason: collision with root package name */
    String f14220b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f258a = str;
        this.f14220b = str2;
        this.f257a = ctVar;
        this.f14219a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f258a, this.f14220b, this.f14219a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f257a != null) {
            this.f257a.a(num, this.f14219a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f257a != null) {
            this.f257a.a(1, this.f14219a);
        }
    }
}
