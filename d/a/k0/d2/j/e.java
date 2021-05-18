package d.a.k0.d2.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.k0.d2.b;
/* loaded from: classes4.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public CustomDialogData f52798g;

    /* renamed from: h  reason: collision with root package name */
    public f f52799h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f52800i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public LinearLayout p;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.j.g
    public void a() {
        this.f52800i = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
        this.j = (TextView) getViewGroup().findViewById(R.id.dialog_title);
        this.k = (TextView) getViewGroup().findViewById(R.id.dialog_body);
        this.l = (TextView) getViewGroup().findViewById(R.id.yes);
        this.m = (TextView) getViewGroup().findViewById(R.id.no);
        this.n = getViewGroup().findViewById(R.id.bdDialog_divider_line);
        this.o = getViewGroup().findViewById(R.id.divider_yes_no_button);
        this.p = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        SkinManager.setBackgroundResource(this.l, R.drawable.dialog_single_button_bg_selector);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.common_color_10122);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.p, R.drawable.dialog_background);
    }

    @Override // d.a.k0.d2.j.g
    public int c() {
        return R.layout.custom_dailog_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.d2.j.g
    /* renamed from: e */
    public void b(CustomDialogData customDialogData) {
        if (customDialogData == null) {
            return;
        }
        this.f52798g = customDialogData;
        CustomDialogData.Head head = customDialogData.head;
        if (!TextUtils.isEmpty(head.imageUrl)) {
            this.f52800i.V(head.imageUrl, 10, false);
        }
        if (!TextUtils.isEmpty(head.text)) {
            this.j.setText(head.text);
        }
        if (!TextUtils.isEmpty(customDialogData.body)) {
            this.k.setText(customDialogData.body);
        }
        CustomDialogData.Button button = customDialogData.leftButton;
        if (button != null && !StringUtils.isNull(button.text)) {
            this.m.setText(customDialogData.leftButton.text);
        }
        CustomDialogData.Button button2 = customDialogData.rightButton;
        if (button2 == null || StringUtils.isNull(button2.text)) {
            return;
        }
        this.l.setText(customDialogData.rightButton.text);
    }

    public void f(f fVar) {
        this.f52799h = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomDialogData.Button button;
        CustomDialogData.Button button2;
        if (view == this.l) {
            CustomDialogData customDialogData = this.f52798g;
            if (customDialogData != null && (button2 = customDialogData.rightButton) != null && !StringUtils.isNull(button2.action)) {
                UrlManager.getInstance().dealOneLink(d(), new String[]{this.f52798g.rightButton.action});
            }
            f fVar = this.f52799h;
            if (fVar != null) {
                fVar.dismiss();
            }
            StatisticItem statisticItem = new StatisticItem(b.a.f52599b);
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
        } else if (view == this.m) {
            CustomDialogData customDialogData2 = this.f52798g;
            if (customDialogData2 != null && (button = customDialogData2.leftButton) != null && !StringUtils.isNull(button.action)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f52796e.getPageActivity(), null, this.f52798g.leftButton.action, true)));
            }
            f fVar2 = this.f52799h;
            if (fVar2 != null) {
                fVar2.dismiss();
            }
            StatisticItem statisticItem2 = new StatisticItem(b.a.f52599b);
            statisticItem2.param("obj_locate", 1);
            TiebaStatic.log(statisticItem2);
        }
    }
}
