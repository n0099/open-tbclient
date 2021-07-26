package d.a.p0.s.s;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.CircleView1080;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f53532e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53533f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53534g;

    /* renamed from: h  reason: collision with root package name */
    public CircleView1080 f53535h;

    /* renamed from: i  reason: collision with root package name */
    public int f53536i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f53532e = str;
            TextView textView = this.f53534g;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f53536i) {
            return;
        }
        this.f53536i = i2;
        TextView textView = this.f53533f;
        if (textView != null) {
            textView.setText(i2 + "%");
        }
        CircleView1080 circleView1080 = this.f53535h;
        if (circleView1080 != null) {
            circleView1080.setProgress(i2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setContentView(R.layout.progress_dialog_1080);
                View findViewById = findViewById(R.id.frame_progress_dialog);
                if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams.topMargin = d.a.d.e.p.l.g(getContext(), R.dimen.tbds50);
                    findViewById.setLayoutParams(layoutParams);
                }
                TextView textView = (TextView) window.findViewById(R.id.text_progress_dialog_message);
                this.f53534g = textView;
                if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53534g.getLayoutParams();
                    layoutParams2.topMargin = d.a.d.e.p.l.g(getContext(), R.dimen.tbds35);
                    this.f53534g.setLayoutParams(layoutParams2);
                }
                if (!StringUtils.isNull(this.f53532e)) {
                    this.f53534g.setText(this.f53532e);
                }
                this.f53533f = (TextView) window.findViewById(R.id.text_progress_dialog_percent);
                this.f53535h = (CircleView1080) window.findViewById(R.id.circle_progress_dialog);
            }
        }
    }
}
