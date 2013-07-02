package org.acra;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import org.acra.collector.CrashReportData;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ CrashReportDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CrashReportDialog crashReportDialog) {
        this.a = crashReportDialog;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(1:3)(1:22)|4|(2:6|(8:8|9|10|11|12|(1:14)|15|16))|21|9|10|11|12|(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b7, code lost:
        android.util.Log.w(org.acra.a.a, "User comment not added: ", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        EditText editText;
        String str;
        SharedPreferences sharedPreferences;
        String str2;
        int u;
        EditText editText2;
        EditText editText3;
        SharedPreferences sharedPreferences2;
        EditText editText4;
        editText = this.a.c;
        if (editText != null) {
            editText4 = this.a.c;
            str = editText4.getText().toString();
        } else {
            str = "";
        }
        sharedPreferences = this.a.b;
        if (sharedPreferences != null) {
            editText2 = this.a.d;
            if (editText2 != null) {
                editText3 = this.a.d;
                str2 = editText3.getText().toString();
                sharedPreferences2 = this.a.b;
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                edit.putString("acra.user.email", str2);
                edit.commit();
                l lVar = new l(this.a.getApplicationContext());
                Log.d(a.a, "Add user comment to " + this.a.a);
                CrashReportData a = lVar.a(this.a.a);
                a.put((CrashReportData) ReportField.USER_COMMENT, (ReportField) str);
                a.put((CrashReportData) ReportField.USER_EMAIL, (ReportField) str2);
                lVar.a(a, this.a.a);
                Log.v(a.a, "About to start SenderWorker from CrashReportDialog");
                a.a().a(false, true);
                u = a.d().u();
                if (u != 0) {
                    org.acra.util.i.a(this.a.getApplicationContext(), u, 1);
                }
                this.a.finish();
            }
        }
        str2 = "";
        l lVar2 = new l(this.a.getApplicationContext());
        Log.d(a.a, "Add user comment to " + this.a.a);
        CrashReportData a2 = lVar2.a(this.a.a);
        a2.put((CrashReportData) ReportField.USER_COMMENT, (ReportField) str);
        a2.put((CrashReportData) ReportField.USER_EMAIL, (ReportField) str2);
        lVar2.a(a2, this.a.a);
        Log.v(a.a, "About to start SenderWorker from CrashReportDialog");
        a.a().a(false, true);
        u = a.d().u();
        if (u != 0) {
        }
        this.a.finish();
    }
}
