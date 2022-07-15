package com.repackage;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rv4 implements SpanWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SpanGroupManager a;
    public int b;
    public int c;

    public rv4(@NonNull SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spanGroupManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = spanGroupManager;
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, spannable, obj, i, i2) == null) {
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{spannable, obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || (spanGroupManager = this.a) == null) {
            return;
        }
        if (obj == Selection.SELECTION_END && this.c != i3) {
            this.c = i3;
            pv4 B = spanGroupManager.B(i3);
            if (B != null) {
                int f = B.f();
                int c = B.c();
                if (Math.abs(this.c - c) <= Math.abs(this.c - f)) {
                    f = c;
                }
                int selectionStart = Selection.getSelectionStart(spannable);
                if (selectionStart > spannable.length()) {
                    selectionStart = spannable.length();
                }
                if (f > spannable.length()) {
                    f = spannable.length();
                }
                Selection.setSelection(spannable, selectionStart, f);
            }
        }
        if (obj != Selection.SELECTION_START || this.b == i3) {
            return;
        }
        this.b = i3;
        pv4 B2 = this.a.B(i3);
        if (B2 != null) {
            int f2 = B2.f();
            int c2 = B2.c();
            if (Math.abs(this.b - c2) <= Math.abs(this.b - f2)) {
                f2 = c2;
            }
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (selectionEnd > spannable.length()) {
                selectionEnd = spannable.length();
            }
            if (f2 > spannable.length()) {
                f2 = spannable.length();
            }
            Selection.setSelection(spannable, f2, selectionEnd);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, spannable, obj, i, i2) == null) {
        }
    }
}
