package d.a.o0.e3.q0;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class g {
    public static void a(NetWork netWork, WriteData writeData) {
        if (writeData == null || !writeData.isHasLocationData()) {
            return;
        }
        netWork.addPostData("is_location", "2");
        Address g2 = d.a.c.e.i.a.k().g(false);
        if (g2 != null) {
            netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(g2.getLatitude()));
            netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(g2.getLongitude()));
        }
        LocationData b2 = d.a.o0.e3.m0.b.a().b();
        if (b2 != null) {
            netWork.addPostData("name", b2.getFormatted_address());
            netWork.addPostData(IAdRequestParam.SN, b2.getSn());
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_write_or_reply_lay, (ViewGroup) null);
        inflate.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        View findViewById = inflate.findViewById(R.id.experience_score);
        TextView textView = (TextView) inflate.findViewById(R.id.success_text);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        TextView textView2 = (TextView) inflate.findViewById(R.id.pre_msg);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0101);
        TextView textView3 = (TextView) inflate.findViewById(R.id.color_msg);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0305);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.success_img);
        if (imageView != null) {
            imageView.setBackgroundDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_toast_succeed40_svg, R.color.CAM_X0101, null));
        }
        if (StringUtils.isNull(str)) {
            str = context.getString(R.string.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        c(context, inflate);
    }

    public static void c(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }
}
