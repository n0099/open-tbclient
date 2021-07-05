package d.a.g.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.m;
/* loaded from: classes8.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, (String) null, 6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56773b = TbadkCoreApplication.getInst().getResources().getString(R.string.switch_to_voice);
        this.f56775d = R.drawable.icon_pure_post_speak24;
        this.f56778g = false;
        this.f56779h = true;
        this.m = true;
        this.l = 5;
        this.k = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        ((View) this.k).setLayoutParams(layoutParams);
        this.n = new int[0];
    }
}
