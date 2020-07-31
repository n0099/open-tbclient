package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes9.dex */
class cp extends AsyncTask<String, Integer, Integer> {
    cm a;

    /* renamed from: a  reason: collision with other field name */
    ct f179a;

    /* renamed from: a  reason: collision with other field name */
    String f180a;
    String b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f180a = str;
        this.b = str2;
        this.f179a = ctVar;
        this.a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f180a, this.b, this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f179a != null) {
            this.f179a.a(num, this.a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f179a != null) {
            this.f179a.a(1, this.a);
        }
    }
}
