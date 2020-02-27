package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes8.dex */
class ck extends AsyncTask<String, Integer, Integer> {
    ch a;

    /* renamed from: a  reason: collision with other field name */
    co f192a;

    /* renamed from: a  reason: collision with other field name */
    String f193a;
    String b;

    public ck(co coVar, String str, String str2, ch chVar) {
        this.f193a = str;
        this.b = str2;
        this.f192a = coVar;
        this.a = chVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cl.a(this.f193a, this.b, this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f192a != null) {
            this.f192a.a(num, this.a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f192a != null) {
            this.f192a.a(1, this.a);
        }
    }
}
