package d.a.m0.r.s;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static final int DIALOG_SIZE_BIG = 1;
    public static final int DIALOG_SIZE_FOR_NEW_PRIVATE = 7;
    public static final int DIALOG_SIZE_FOR_PRIVACY_POLICY_GUIDE = 8;
    public static final int DIALOG_SIZE_FOR_PRIVATE = 3;
    public static final int DIALOG_SIZE_PRIVATE = 2;
    public static final int DIALOG_SIZE_SMALL = 0;
    public static final int DIALOG_SIZW_PRIVACY_BUTTON = 6;
    public static final int DIALOG_SIZW_PUSH_PERMISSION = 4;
    public static final int DIALOG_SIZW_YOUNGSTER = 5;
    public View bdDialog_divider_line;
    public View dividerWithButton;
    public Handler handler;
    public TextView introTextView;
    public final Activity mActivity;
    public DialogInterface.OnCancelListener mCancelListenr;
    public Button mCloseButton;
    public e mCloseButtonListener;
    public View mContentView;
    public AlertDialog mDialog;
    public DialogInterface.OnDismissListener mDismissListener;
    public String mMessage;
    public e mNegativeButtonListener;
    public String mNegativeButtonTip;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public e mPositiveButtonListener;
    public String mPositiveButtonTip;
    public ViewGroup mRealView;
    public final ViewGroup mRootView;
    public String mTitle;
    public TextView noButton;
    public TextView noTipAgain;
    public ImageView noTipAgainCheckBox;
    public f onNoTipAgainCheckListener;
    public TextView titleTextView;
    public TextView yesButton;
    public Object yesTag;
    public int mDialogGravity = -1;
    public boolean isOnlyMessageShowCenter = true;
    public boolean isMessageShowCenter = false;
    public boolean isTitleShowCenter = false;
    public int mButtonTextColorId = -1;
    public int mNegativeTextColorId = -1;
    public int dialogSize = 0;
    public boolean mDialogCreated = false;
    public boolean cancelableFlag = true;
    public boolean mCancelable = true;
    public boolean isAutoNight = true;
    public boolean useNoTipAgainStyle = false;
    public boolean noTipAgainChecked = false;
    public int animRes = -1;

    /* renamed from: d.a.m0.r.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1146a implements View.OnClickListener {
        public View$OnClickListenerC1146a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.noTipAgainChecked = !aVar.noTipAgainChecked;
            a.this.setCheckBoxDrawable();
            if (a.this.onNoTipAgainCheckListener != null) {
                a.this.onNoTipAgainCheckListener.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f50208a;

        public b(a aVar, AtomicBoolean atomicBoolean) {
            this.f50208a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f50208a.set(true);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.show(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final a f50210e;

        /* renamed from: f  reason: collision with root package name */
        public final e f50211f;

        public d(a aVar, a aVar2, e eVar) {
            this.f50210e = aVar2;
            this.f50211f = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = this.f50211f;
            if (eVar != null) {
                eVar.onClick(this.f50210e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onClick(a aVar);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();
    }

    public a(Activity activity) {
        this.mActivity = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdalert, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mRealView = (ViewGroup) viewGroup.findViewById(R.id.real_view);
    }

    private void changeContentWithNoTipAgainSkinType() {
        SkinManager.setViewTextColor(this.titleTextView, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.introTextView, R.color.CAM_X0107);
        setCheckBoxDrawable();
        SkinManager.setViewTextColor(this.noTipAgain, R.color.CAM_X0107);
    }

    private void initButtonStyle() {
        TextView textView = this.noButton;
        if (textView != null) {
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(textView);
            d2.u(R.color.CAM_X0302);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0211);
        }
        TextView textView2 = this.yesButton;
        if (textView2 != null) {
            d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(textView2);
            d3.u(R.color.CAM_X0302);
            d3.m(R.string.J_X06);
            d3.f(R.color.CAM_X0211);
        }
    }

    private void mouldButtons(boolean z, boolean z2) {
        View view;
        View view2;
        View view3;
        if (z && z2) {
            View view4 = this.dividerWithButton;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            View view5 = this.bdDialog_divider_line;
            if (view5 != null) {
                view5.setVisibility(0);
                return;
            }
            return;
        }
        if (isAutoNight()) {
            TbadkCoreApplication.getInst().getSkinType();
        }
        View view6 = this.dividerWithButton;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        if (!z && !z2) {
            TextView textView = this.yesButton;
            if (textView == null || this.noButton == null || this.dividerWithButton == null || this.bdDialog_divider_line == null) {
                return;
            }
            textView.setVisibility(8);
            this.noButton.setVisibility(8);
            this.dividerWithButton.setVisibility(8);
            this.bdDialog_divider_line.setVisibility(8);
        } else if (z) {
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.yesButton);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0211);
            if (this.noButton == null || this.dividerWithButton == null || (view3 = this.bdDialog_divider_line) == null) {
                return;
            }
            view3.setVisibility(0);
            this.yesButton.setVisibility(0);
            this.noButton.setVisibility(8);
        } else if (z2) {
            d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.noButton);
            d3.m(R.string.J_X06);
            d3.f(R.color.CAM_X0211);
            if (this.yesButton == null || this.dividerWithButton == null || (view2 = this.bdDialog_divider_line) == null) {
                return;
            }
            view2.setVisibility(0);
            this.noButton.setVisibility(0);
            this.yesButton.setVisibility(8);
        } else if (this.yesButton == null || this.noButton == null || (view = this.bdDialog_divider_line) == null) {
        } else {
            view.setVisibility(8);
            this.yesButton.setVisibility(8);
            this.noButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckBoxDrawable() {
        Drawable maskDrawable;
        ImageView imageView = this.noTipAgainCheckBox;
        if (imageView == null) {
            return;
        }
        if (this.noTipAgainChecked) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a show(boolean z) {
        if (this.mDialogCreated) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog != null) {
                if (z) {
                    d.a.c.e.m.g.i(alertDialog, this.mActivity);
                } else {
                    alertDialog.show();
                }
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog = create;
            create.setCanceledOnTouchOutside(this.cancelableFlag);
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnKeyListener(this.mOnKeyListener);
            DialogInterface.OnCancelListener onCancelListener = this.mCancelListenr;
            if (onCancelListener != null) {
                this.mDialog.setOnCancelListener(onCancelListener);
            }
            DialogInterface.OnDismissListener onDismissListener = this.mDismissListener;
            if (onDismissListener != null) {
                this.mDialog.setOnDismissListener(onDismissListener);
            }
            if (z) {
                d.a.c.e.m.g.i(this.mDialog, this.mActivity);
            } else {
                this.mDialog.show();
            }
            if (this.mDialog.getWindow().getDecorView().getParent() == null) {
                return this;
            }
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = d.a.c.e.p.l.q(this.mActivity);
            if (q != null) {
                int dialogMargin = getDialogMargin();
                if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                    attributes.width = q.heightPixels - (dialogMargin * 2);
                } else {
                    attributes.width = q.widthPixels - (dialogMargin * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.mRootView);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.mRootView, false, new b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
            int i2 = this.animRes;
            if (i2 != -1) {
                window.setWindowAnimations(i2);
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }

    public void autoChangeSkinType(@Nullable d.a.c.a.f<?> fVar) {
        int i2;
        int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().f49656e = !isAutoNight();
            tbPageContext.getLayoutMode().j(this.mRootView);
            if (this.mContentView != null) {
                tbPageContext.getLayoutMode().j(this.mContentView);
            }
        }
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(R.drawable.transparent_bg);
        }
        if (this.mRealView != null && ((i2 = this.dialogSize) == 2 || i2 == 5)) {
            this.mRealView.setBackgroundResource(R.drawable.dialog_private_background);
        } else {
            SkinManager.setBackgroundResource(this.mRealView, R.drawable.dialog_background, skinType);
        }
        changeContentWithNoTipAgainSkinType();
    }

    public a create(@Nullable d.a.c.a.f<?> fVar) {
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (this.mDialogCreated) {
            return this;
        }
        boolean z2 = true;
        this.mDialogCreated = true;
        LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.dialog_content);
        this.yesButton = (TextView) this.mRootView.findViewById(R.id.yes);
        this.noButton = (TextView) this.mRootView.findViewById(R.id.no);
        this.dividerWithButton = this.mRootView.findViewById(R.id.divider_yes_no_button);
        this.bdDialog_divider_line = this.mRootView.findViewById(R.id.bdDialog_divider_line);
        this.mCloseButton = (Button) this.mRootView.findViewById(R.id.close_btn);
        initButtonStyle();
        if (this.mContentView != null) {
            linearLayout.removeAllViews();
            if (this.mContentView.getParent() != null) {
                if (this.mContentView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                    linearLayout.addView(this.mContentView);
                }
            } else {
                linearLayout.addView(this.mContentView);
            }
        } else {
            View createContentViewWithNoTipAgain = this.useNoTipAgainStyle ? createContentViewWithNoTipAgain() : isShowTitleAndMessage();
            if (createContentViewWithNoTipAgain != null) {
                linearLayout.removeAllViews();
                if (createContentViewWithNoTipAgain.getParent() != null) {
                    if (createContentViewWithNoTipAgain.getParent() instanceof ViewGroup) {
                        ((ViewGroup) createContentViewWithNoTipAgain.getParent()).removeView(createContentViewWithNoTipAgain);
                        linearLayout.addView(createContentViewWithNoTipAgain);
                    }
                } else {
                    linearLayout.addView(createContentViewWithNoTipAgain);
                }
            }
        }
        autoChangeSkinType(fVar);
        if (this.mCloseButtonListener != null) {
            this.mCloseButton.setVisibility(0);
            this.mCloseButton.setOnClickListener(new d(this, this, this.mCloseButtonListener));
            SkinManager.setBackgroundResource(this.mCloseButton, R.drawable.icon_popup_close_n, isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0);
        }
        if (this.mButtonTextColorId != -1) {
            TextView textView4 = this.yesButton;
            if (textView4 != null) {
                d.a.m0.r.u.c.d(textView4).u(this.mButtonTextColorId);
            }
            TextView textView5 = this.noButton;
            if (textView5 != null) {
                d.a.m0.r.u.c.d(textView5).u(this.mButtonTextColorId);
            }
        }
        if (this.mNegativeTextColorId != -1 && (textView3 = this.noButton) != null) {
            d.a.m0.r.u.c.d(textView3).u(this.mNegativeTextColorId);
        }
        if (TextUtils.isEmpty(this.mPositiveButtonTip) || (textView2 = this.yesButton) == null) {
            z = false;
        } else {
            textView2.setText(this.mPositiveButtonTip);
            this.yesButton.setTag(this.yesTag);
            e eVar = this.mPositiveButtonListener;
            if (eVar != null) {
                this.yesButton.setOnClickListener(new d(this, this, eVar));
            }
            z = true;
        }
        if (TextUtils.isEmpty(this.mNegativeButtonTip) || (textView = this.noButton) == null) {
            z2 = false;
        } else {
            textView.setText(this.mNegativeButtonTip);
            e eVar2 = this.mNegativeButtonListener;
            if (eVar2 != null) {
                this.noButton.setOnClickListener(new d(this, this, eVar2));
            }
        }
        mouldButtons(z, z2);
        return this;
    }

    public View createContentViewWithNoTipAgain() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_content_with_no_tip_again, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        this.titleTextView = textView;
        textView.setText(this.mTitle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.intro);
        this.introTextView = textView2;
        textView2.setText(this.mMessage);
        this.noTipAgain = (TextView) inflate.findViewById(R.id.no_tip_again_text);
        this.noTipAgainCheckBox = (ImageView) inflate.findViewById(R.id.checkbox);
        setCheckBoxDrawable();
        this.noTipAgainCheckBox.setOnClickListener(new View$OnClickListenerC1146a());
        return inflate;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.mActivity);
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public int getDialogMargin() {
        int i2 = R.dimen.tbds0;
        int i3 = this.dialogSize;
        if (i3 == 0) {
            i2 = R.dimen.ds90;
        } else if (i3 == 1) {
            i2 = R.dimen.ds40;
        } else if (i3 == 2 || i3 == 6) {
            i2 = R.dimen.tbds44;
        } else if (i3 == 3) {
            i2 = R.dimen.tbds45;
        } else if (i3 == 4 || i3 == 5) {
            i2 = R.dimen.tbds50;
        } else if (i3 == 7) {
            i2 = R.dimen.tbds206;
        } else if (i3 == 8) {
            i2 = R.dimen.tbds120;
        }
        return d.a.c.e.p.l.g(this.mActivity, i2);
    }

    public DialogInterface.OnKeyListener getOnKeyListener() {
        return this.mOnKeyListener;
    }

    public ViewGroup getRealView() {
        return this.mRealView;
    }

    public Window getWindow() {
        return this.mDialog.getWindow();
    }

    public Object getYesButtonTag() {
        return this.yesTag;
    }

    public void hide() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.hide();
        }
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public boolean isNoTipAgainChecked() {
        return this.noTipAgainChecked;
    }

    public View isShowTitleAndMessage() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = !StringUtils.isNull(this.mMessage);
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.message_view);
                if (this.isMessageShowCenter) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.isTitleShowCenter) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.message_view);
            if (z) {
                textView3.setText(this.mTitle);
            } else {
                if (this.isOnlyMessageShowCenter) {
                    textView3.setGravity(17);
                }
                textView3.setText(this.mMessage);
            }
            return linearLayout2;
        }
        return null;
    }

    public boolean isShowing() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public void reset() {
        this.mDialogCreated = false;
    }

    public void setAnimRes(int i2) {
        this.animRes = i2;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public a setButtonTextColor(int i2) {
        this.mButtonTextColorId = i2;
        return this;
    }

    public a setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
        return this;
    }

    public a setCloseButton(e eVar) {
        if (eVar != null) {
            this.mCloseButtonListener = eVar;
        }
        return this;
    }

    public a setContentView(View view) {
        this.mContentView = view;
        return this;
    }

    public a setContentViewId(int i2) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mContentView = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null);
        }
        return this;
    }

    public a setContentViewSize(int i2) {
        this.dialogSize = i2;
        return this;
    }

    public a setGravity(int i2) {
        this.mDialogGravity = i2;
        return this;
    }

    public a setMessage(String str) {
        this.mMessage = str;
        return this;
    }

    public a setMessageId(int i2) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mMessage = activity.getResources().getString(i2);
        }
        return this;
    }

    public void setMessageShowCenter(boolean z) {
        this.isMessageShowCenter = z;
    }

    public a setNegativeButton(String str, e eVar) {
        this.mNegativeButtonTip = str;
        this.mNegativeButtonListener = eVar;
        return this;
    }

    public a setNegativeTextColor(int i2) {
        this.mNegativeTextColorId = i2;
        return this;
    }

    public void setNoBtnClickable(boolean z) {
        TextView textView = this.noButton;
        if (textView != null) {
            textView.setClickable(z);
        }
    }

    public a setOnCalcelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mCancelListenr = onCancelListener;
        return this;
    }

    public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    public void setOnNoTipAgainCheckListener(f fVar) {
        this.onNoTipAgainCheckListener = fVar;
    }

    public void setOnlyMessageShowCenter(boolean z) {
        this.isOnlyMessageShowCenter = z;
    }

    public a setPositiveButton(String str, e eVar) {
        this.mPositiveButtonTip = str;
        this.mPositiveButtonListener = eVar;
        return this;
    }

    public void setRealView(ViewGroup viewGroup) {
        this.mRealView = viewGroup;
    }

    public a setTitle(String str) {
        this.mTitle = str;
        return this;
    }

    public void setTitleShowCenter(boolean z) {
        this.isTitleShowCenter = z;
    }

    public void setUseNoTipAgainStyle(boolean z) {
        this.useNoTipAgainStyle = z;
    }

    public void setYesBtnClickable(boolean z) {
        TextView textView = this.yesButton;
        if (textView != null) {
            textView.setClickable(z);
        }
    }

    public void setYesButtonTag(Object obj) {
        this.yesTag = obj;
    }

    public a showNoCheck() {
        return show(false);
    }

    public a setTitle(int i2) {
        setTitle(this.mActivity.getResources().getString(i2));
        return this;
    }

    public a setNegativeButton(int i2, e eVar) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mNegativeButtonTip = activity.getResources().getString(i2);
            this.mNegativeButtonListener = eVar;
        }
        return this;
    }

    public a setPositiveButton(int i2, e eVar) {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mPositiveButtonTip = activity.getResources().getString(i2);
            this.mPositiveButtonListener = eVar;
        }
        return this;
    }

    public a show() {
        return show(true);
    }

    public void show(long j) {
        Handler handler = new Handler();
        this.handler = handler;
        handler.postDelayed(new c(), j);
    }
}
