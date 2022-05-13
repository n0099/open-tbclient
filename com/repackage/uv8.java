package com.repackage;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uv8 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;
    public yf5 b;
    public int c;

    public uv8(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spannable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = 0;
        this.a = spannable;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        yf5 yf5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (action == 3 && (yf5Var = this.b) != null) {
                    yf5Var.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view2.invalidate();
                    this.b = null;
                    return false;
                }
                if (action == 1 || action == 0) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    Layout layout = textView.getLayout();
                    if (layout == null) {
                        return false;
                    }
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                    Spannable spannable = this.a;
                    if (spannable == null) {
                        return false;
                    }
                    yf5[] yf5VarArr = (yf5[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, yf5.class);
                    if (yf5VarArr != null && yf5VarArr.length != 0 && yf5VarArr[0] != null) {
                        if (action == 1) {
                            yf5VarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                            yf5VarArr[0].onClick(textView);
                            view2.invalidate();
                        } else {
                            yf5 yf5Var2 = yf5VarArr[0];
                            this.b = yf5Var2;
                            if (yf5Var2.e()) {
                                int i = this.c;
                                if (i != 0) {
                                    yf5VarArr[0].g(SkinManager.getColor(i));
                                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    yf5VarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                                } else {
                                    yf5VarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                                }
                            }
                            Spannable spannable2 = this.a;
                            Selection.setSelection(spannable2, spannable2.getSpanStart(yf5VarArr[0]), this.a.getSpanEnd(yf5VarArr[0]));
                            view2.invalidate();
                        }
                        return true;
                    }
                    yf5 yf5Var3 = this.b;
                    if (yf5Var3 != null) {
                        yf5Var3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        view2.invalidate();
                    }
                    Selection.removeSelection(this.a);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
