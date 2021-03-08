package com.xiaomi.push;

import android.os.AsyncTask;
/* loaded from: classes5.dex */
class cp extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    cm f8306a;

    /* renamed from: a  reason: collision with other field name */
    ct f177a;

    /* renamed from: a  reason: collision with other field name */
    String f178a;
    String b;

    public cp(ct ctVar, String str, String str2, cm cmVar) {
        this.f178a = str;
        this.b = str2;
        this.f177a = ctVar;
        this.f8306a = cmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        return Integer.valueOf(cq.a(this.f178a, this.b, this.f8306a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f177a != null) {
            this.f177a.a(num, this.f8306a);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (this.f177a != null) {
            this.f177a.a(1, this.f8306a);
        }
    }
}
