package com.kascend.chushou.view.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.kascend.chushou.a;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public abstract class b extends Fragment {
    protected Context mContext;
    protected final String TAG = getClass().getSimpleName();
    protected ProgressDialog mProgressDialog = null;
    protected final io.reactivex.disposables.a mCompositeDisposable = new io.reactivex.disposables.a();
    protected boolean mIsViewCreated = false;

    protected abstract View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    @Override // android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        tv.chushou.zues.utils.e.d(this.TAG, "onCreate()<----");
        super.onCreate(bundle);
        this.mContext = getActivity();
        tv.chushou.zues.utils.e.d(this.TAG, "onCreate()---->");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (isFinishing()) {
            tv.chushou.zues.utils.e.e(this.TAG, "finishing! return in onCreateView");
            View view = new View(this.mContext);
            this.mIsViewCreated = true;
            return view;
        }
        View initView = initView(layoutInflater, viewGroup, bundle);
        initData();
        this.mIsViewCreated = true;
        return initView;
    }

    protected void initData() {
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.mCompositeDisposable.dispose();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mProgressDialog != null) {
            if (this.mProgressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = null;
        }
        unInit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unInit() {
    }

    public void showApiError(boolean z, int i, String str) {
        if (z) {
            if (!tv.chushou.zues.utils.a.eHN()) {
                showStatus(3);
                return;
            } else {
                showStatus(e.Rt(i));
                return;
            }
        }
        if (!tv.chushou.zues.utils.a.eHN()) {
            str = this.mContext.getString(a.i.s_no_available_network);
        } else if (h.isEmpty(str)) {
            str = this.mContext.getString(a.i.str_errpr_pop);
        }
        g.d(this.mContext, str);
    }

    public void showProgressDialog(boolean z) {
        if (this.mContext != null) {
            showProgressDialog(z, this.mContext.getString(a.i.update_userinfo_ing));
        }
    }

    public void showProgressDialog(boolean z, @StringRes int i) {
        if (this.mContext != null) {
            showProgressDialog(z, this.mContext.getString(i));
        }
    }

    public void showProgressDialog(boolean z, String str) {
        if (z) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this.mContext);
                this.mProgressDialog.setProgressStyle(0);
                this.mProgressDialog.requestWindowFeature(1);
                this.mProgressDialog.setCancelable(true);
            }
            this.mProgressDialog.setMessage(str);
            if (!this.mProgressDialog.isShowing()) {
                this.mProgressDialog.show();
            }
        } else if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void showStatus(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFinishing() {
        return this.mContext == null || ((Activity) this.mContext).isFinishing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
