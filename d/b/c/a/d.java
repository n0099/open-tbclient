package d.b.c.a;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d<T> {
    public f<T> mContext;
    public InputMethodManager mInputManager = null;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public View f41967e;

        public a(View view) {
            this.f41967e = null;
            this.f41967e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            f<T> fVar = d.this.mContext;
            if (fVar == null || fVar.getPageActivity() == null || d.this.mContext.getPageActivity().isFinishing()) {
                return;
            }
            d.this.ShowSoftKeyPad(this.f41967e);
        }
    }

    public d(f<T> fVar) {
        this.mContext = null;
        this.mContext = fVar;
    }

    public void HidenSoftKeyPad(View view) {
        try {
            if (this.mInputManager == null) {
                getInputMethodManager();
            }
            if (this.mInputManager != null && view != null) {
                this.mInputManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void ShowSoftKeyPad(View view) {
        try {
            getInputMethodManager().showSoftInput(view, 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i) {
        new Handler().postDelayed(new a(view), i);
    }

    public void destroy() {
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputManager == null) {
            this.mInputManager = (InputMethodManager) this.mContext.getContext().getSystemService("input_method");
        }
        return this.mInputManager;
    }

    public f<T> getPageContext() {
        return this.mContext;
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        this.mInputManager = inputMethodManager;
    }
}
