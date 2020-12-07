package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes18.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f4613a;

    /* renamed from: a  reason: collision with other field name */
    ct f178a;

    /* renamed from: a  reason: collision with other field name */
    String f179a;
    String b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f179a = str;
        this.b = str2;
        this.f178a = ctVar;
        this.f4613a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f179a, this.b, this.f4613a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f178a != null) {
            this.f178a.a(num, this.f4613a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f178a != null) {
            this.f178a.a(1, this.f4613a);
        }
    }
}
