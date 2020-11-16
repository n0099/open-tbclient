package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes18.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f4843a;

    /* renamed from: a  reason: collision with other field name */
    ct f180a;

    /* renamed from: a  reason: collision with other field name */
    String f181a;
    String b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f181a = str;
        this.b = str2;
        this.f180a = ctVar;
        this.f4843a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f181a, this.b, this.f4843a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f180a != null) {
            this.f180a.a(num, this.f4843a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f180a != null) {
            this.f180a.a(1, this.f4843a);
        }
    }
}
