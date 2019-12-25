package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes5.dex */
class ck extends AsyncTask<String, Integer, Integer> {
    ch a;

    /* renamed from: a  reason: collision with other field name */
    co f196a;

    /* renamed from: a  reason: collision with other field name */
    String f197a;
    String b;

    public ck(co coVar, String str, String str2, ch chVar) {
        this.f197a = str;
        this.b = str2;
        this.f196a = coVar;
        this.a = chVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cl.a(this.f197a, this.b, this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f196a != null) {
            this.f196a.a(num, this.a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f196a != null) {
            this.f196a.a(1, this.a);
        }
    }
}
