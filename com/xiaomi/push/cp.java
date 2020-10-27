package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes12.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f4841a;

    /* renamed from: a  reason: collision with other field name */
    ct f175a;

    /* renamed from: a  reason: collision with other field name */
    String f176a;
    String b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f176a = str;
        this.b = str2;
        this.f175a = ctVar;
        this.f4841a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f176a, this.b, this.f4841a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f175a != null) {
            this.f175a.a(num, this.f4841a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f175a != null) {
            this.f175a.a(1, this.f4841a);
        }
    }
}
