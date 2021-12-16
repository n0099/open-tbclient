package com.dxmpay.wallet.base.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes2.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View contentView;

    /* renamed from: e  reason: collision with root package name */
    public Button f55974e;

    /* renamed from: f  reason: collision with root package name */
    public Button f55975f;

    /* renamed from: g  reason: collision with root package name */
    public Button f55976g;

    /* renamed from: h  reason: collision with root package name */
    public Button f55977h;

    /* renamed from: i  reason: collision with root package name */
    public Button f55978i;

    /* renamed from: j  reason: collision with root package name */
    public Button f55979j;

    /* renamed from: k  reason: collision with root package name */
    public Button f55980k;
    public Button l;
    public Button m;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public boolean miniMode;
    public SafeKeyBoardEditText mySafeEditText;
    public Button n;
    public ImageButton o;
    public e p;

    /* loaded from: classes2.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardPopupWindow f55981e;

        public b(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55981e = safeKeyBoardPopupWindow;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f55981e.h();
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    this.f55981e.g();
                    return false;
                } else if (motionEvent.getAction() != 2 || this.f55981e.o.isPressed()) {
                    return false;
                } else {
                    this.f55981e.g();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardPopupWindow f55982e;

        public c(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55982e = safeKeyBoardPopupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int selectionStart = this.f55982e.mySafeEditText.getSelectionStart();
                int selectionEnd = this.f55982e.mySafeEditText.getSelectionEnd();
                Editable text = this.f55982e.mySafeEditText.getText();
                if (selectionStart >= 0) {
                    if (selectionStart < selectionEnd) {
                        text.replace(selectionStart, selectionEnd, "", 0, 0);
                    } else if (selectionStart != selectionEnd) {
                        text.replace(selectionEnd, selectionStart, "", 0, 0);
                    } else if (selectionStart > 0) {
                        text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f55983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardPopupWindow f55984f;

        public d(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55984f = safeKeyBoardPopupWindow;
            this.f55983e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int selectionStart = this.f55984f.mySafeEditText.getSelectionStart();
                int selectionEnd = this.f55984f.mySafeEditText.getSelectionEnd();
                Editable text = this.f55984f.mySafeEditText.getText();
                if (selectionStart >= 0) {
                    if (selectionStart < selectionEnd) {
                        text.replace(selectionStart, selectionEnd, this.f55983e.getTag().toString(), 0, this.f55983e.getTag().toString().length());
                    } else if (selectionStart == selectionEnd) {
                        text.replace(selectionStart, selectionStart, this.f55983e.getTag().toString(), 0, this.f55983e.getTag().toString().length());
                    } else {
                        text.replace(selectionEnd, selectionStart, this.f55983e.getTag().toString(), 0, this.f55983e.getTag().toString().length());
                        int selectionEnd2 = this.f55984f.mySafeEditText.getSelectionEnd() + this.f55983e.getTag().toString().length();
                        if (selectionEnd2 < 0 || selectionEnd2 > this.f55984f.mySafeEditText.getText().toString().length()) {
                            return;
                        }
                        Selection.setSelection(this.f55984f.mySafeEditText.getEditableText(), selectionEnd2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SafeKeyBoardPopupWindow> a;

        public e(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.a.get();
                if (safeKeyBoardPopupWindow == null) {
                    return;
                }
                if (!TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                    int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                    int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                    Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                    if (selectionStart >= 0) {
                        if (selectionStart < selectionEnd) {
                            text.replace(selectionStart, selectionEnd, "", 0, 0);
                        } else if (selectionStart != selectionEnd) {
                            text.replace(selectionEnd, selectionStart, "", 0, 0);
                        } else if (selectionStart > 0) {
                            text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                        }
                        removeCallbacksAndMessages(null);
                        sendEmptyMessageDelayed(1, 200L);
                        return;
                    }
                    return;
                }
                removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        d();
    }

    @TargetApi(24)
    public final boolean b() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
                return false;
            }
            return ((Activity) context).isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    public final int[] c(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                if (i3 >= 10) {
                    break;
                }
                arrayList.add(Integer.valueOf(i3));
                i3++;
            }
            int[] iArr = new int[10];
            if (z) {
                Random random = new Random();
                for (i2 = 10; i2 > 0; i2--) {
                    int nextInt = random.nextInt(i2);
                    iArr[10 - i2] = ((Integer) arrayList.get(nextInt)).intValue();
                    arrayList.remove(nextInt);
                }
            } else {
                for (int i4 = 0; i4 < 10; i4++) {
                    iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                }
            }
            return iArr;
        }
        return (int[]) invokeZ.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.miniMode = b();
            View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
            this.contentView = inflate;
            setContentView(inflate);
            setHeight(-2);
            setWidth(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setAnimationStyle(ResUtils.style(this.mContext, "dxm_wallet_safekeyboard_popwindown_anim"));
            c.f.b.g.b.a().d(this);
            this.n = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
            this.f55974e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
            this.f55975f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
            this.f55976g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
            this.f55977h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
            this.f55978i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
            this.f55979j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
            this.f55980k = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
            this.l = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
            this.m = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
            this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
            ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
            this.o = imageButton;
            AccessibilityUtils.setContentDescription(imageButton, ResUtils.getString(this.mContext, "dxm_wallet_base_delete"));
            this.n.setOnClickListener(this);
            this.f55974e.setOnClickListener(this);
            this.f55975f.setOnClickListener(this);
            this.f55976g.setOnClickListener(this);
            this.f55977h.setOnClickListener(this);
            this.f55978i.setOnClickListener(this);
            this.f55979j.setOnClickListener(this);
            this.f55980k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.mButtonX.setOnClickListener(this);
            this.o.setOnFocusChangeListener(new a(this));
            this.o.setOnTouchListener(new b(this));
            setSoftInputMode(16);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.p == null) {
                this.p = new e(this);
            }
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ResUtils.layout(this.mContext, this.miniMode ? "dxm_wallet_base_safekeyboard_popupwindow_mini" : "dxm_wallet_base_safekeyboard_popupwindow");
        }
        return invokeV.intValue;
    }

    public int getPopupWindowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.contentView.getHeight() : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.p == null) {
                this.p = new e(this);
            }
            this.p.sendEmptyMessage(1);
        }
    }

    public void initKeyNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            int[] c2 = c(z);
            Button button = this.n;
            button.setText("" + c2[0]);
            this.n.setTag(Integer.valueOf(c2[0]));
            Button button2 = this.f55974e;
            button2.setText("" + c2[1]);
            this.f55974e.setTag(Integer.valueOf(c2[1]));
            Button button3 = this.f55975f;
            button3.setText("" + c2[2]);
            this.f55975f.setTag(Integer.valueOf(c2[2]));
            Button button4 = this.f55976g;
            button4.setText("" + c2[3]);
            this.f55976g.setTag(Integer.valueOf(c2[3]));
            Button button5 = this.f55977h;
            button5.setText("" + c2[4]);
            this.f55977h.setTag(Integer.valueOf(c2[4]));
            Button button6 = this.f55978i;
            button6.setText("" + c2[5]);
            this.f55978i.setTag(Integer.valueOf(c2[5]));
            Button button7 = this.f55979j;
            button7.setText("" + c2[6]);
            this.f55979j.setTag(Integer.valueOf(c2[6]));
            Button button8 = this.f55980k;
            button8.setText("" + c2[7]);
            this.f55980k.setTag(Integer.valueOf(c2[7]));
            Button button9 = this.l;
            button9.setText("" + c2[8]);
            this.l.setTag(Integer.valueOf(c2[8]));
            Button button10 = this.m;
            button10.setText("" + c2[9]);
            this.m.setTag(Integer.valueOf(c2[9]));
            if (this.mySafeEditText.getUseKeyX()) {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_numkey_selector"));
                this.mButtonX.setText("X");
                this.mButtonX.setTag("X");
            } else if (this.mySafeEditText.getUseKeyDot()) {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_numkey_selector"));
                this.mButtonX.setText(".");
                this.mButtonX.setTag(".");
            } else {
                this.mButtonX.setEnabled(false);
                this.mButtonX.setText("");
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_delkey_selector"));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view.getId() == ResUtils.id(this.mContext, "btn_del")) {
                if (TextUtils.isEmpty(this.mySafeEditText.getText())) {
                    return;
                }
                new Handler().post(new c(this));
                return;
            }
            new Handler().post(new d(this, view));
        }
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, safeKeyBoardEditText) == null) {
            this.mySafeEditText = safeKeyBoardEditText;
        }
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, safeScrollView) == null) {
            this.mSafeScrollView = safeScrollView;
        }
    }

    @Override // android.widget.PopupWindow
    public void update() {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.update();
            if (!isShowing() || (safeKeyBoardEditText = this.mySafeEditText) == null) {
                return;
            }
            safeKeyBoardEditText.isShowLogoLockAnim();
        }
    }
}
