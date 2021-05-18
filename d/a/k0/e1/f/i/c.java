package d.a.k0.e1.f.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import d.a.j0.s.d.d;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public abstract class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f54185e;

    /* renamed from: f  reason: collision with root package name */
    public List<ImMessageCenterShowItemData> f54186f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54187g = false;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54190c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f54191d;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f54188a = null;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f54189b = null;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54192e = null;

        /* renamed from: f  reason: collision with root package name */
        public TextView f54193f = null;

        /* renamed from: g  reason: collision with root package name */
        public TextView f54194g = null;

        /* renamed from: h  reason: collision with root package name */
        public MessageRedDotView f54195h = null;

        /* renamed from: i  reason: collision with root package name */
        public View f54196i = null;
        public ImageView j = null;
        public ImageView k = null;
        public ImageView l = null;

        public a(c cVar) {
        }
    }

    public c(Context context) {
        this.f54185e = null;
        this.f54185e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i2) {
        List<ImMessageCenterShowItemData> list = this.f54186f;
        if (list == null || list.size() == 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f54186f.get(i2);
    }

    public a b(View view) {
        a aVar = new a(this);
        aVar.f54188a = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.f54190c = (ImageView) view.findViewById(R.id.svg_head);
        aVar.f54189b = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.f54191d = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.f54192e = (TextView) view.findViewById(R.id.chat_name);
        aVar.f54193f = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.f54194g = (TextView) view.findViewById(R.id.chat_time);
        aVar.f54196i = view.findViewById(R.id.line);
        MessageRedDotView messageRedDotView = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.f54195h = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
        aVar.j = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.k = (ImageView) view.findViewById(R.id.send_status);
        aVar.l = (ImageView) view.findViewById(R.id.select_status);
        aVar.f54189b.setPlaceHolder(1);
        return aVar;
    }

    public boolean c() {
        return this.f54187g;
    }

    public abstract boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            aVar.j.setVisibility(8);
        } else if (d(imMessageCenterShowItemData)) {
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                aVar.j.setVisibility(8);
            } else if (!groupSetting.isAcceptNotify()) {
                aVar.j.setVisibility(0);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(aVar.j, R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                aVar.j.setVisibility(8);
            }
        } else {
            aVar.j.setVisibility(8);
        }
    }

    public abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public int getCount() {
        List<ImMessageCenterShowItemData> list = this.f54186f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar = view != null ? (a) view.getTag() : null;
        if (aVar == null) {
            view = LayoutInflater.from(this.f54185e).inflate(R.layout.chat_list_item, viewGroup, false);
            aVar = b(view);
            view.setTag(aVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setBackgroundResource(aVar.f54196i, R.color.CAM_X0205);
        aVar.f54188a.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i2);
        if (item != null) {
            i(aVar, item);
            h(aVar, item);
            k(aVar, item);
            l(aVar, item);
            g(aVar, item);
            m(aVar, item);
            f(aVar, item);
            j(aVar, item);
        }
        return view;
    }

    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.f54193f.setText("");
        } else {
            aVar.f54193f.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return;
        }
        aVar.f54192e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.f54187g) {
            aVar.l.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_s);
                SkinManager.setBackgroundColor(aVar.f54188a, R.color.CAM_X0205);
                return;
            }
            SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_n);
            SkinManager.setBackgroundColor(aVar.f54188a, R.color.CAM_X0205);
            return;
        }
        aVar.l.setVisibility(8);
        TBSelector.setViewBackgroundColorWithPressedState(aVar.f54188a, R.color.CAM_X0205, R.color.CAM_X0204);
    }

    public void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar == null || imMessageCenterShowItemData == null || imMessageCenterShowItemData.getOwnerName() == null) {
            return;
        }
        if (e(imMessageCenterShowItemData)) {
            aVar.k.setVisibility(0);
            if (imMessageCenterShowItemData.getSendStatus() == 2) {
                SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_failed_information);
                return;
            } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_in_information);
                return;
            } else {
                aVar.k.setVisibility(8);
                return;
            }
        }
        aVar.k.setVisibility(8);
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar == null || imMessageCenterShowItemData == null) {
            return;
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        aVar.f54194g.setText(imMessageCenterShowItemData.getServerTime() != 0 ? StringHelper.getChatTimeString(date) : "");
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.d().e() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair p = p(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (p != null && p.getName() != null && p.getName().length() > 0) {
                    unReadCount = d.a.c.e.m.b.d(p.getName(), 0);
                }
            }
            aVar.f54195h.setThreeDotMode(2);
            aVar.f54195h.f(unReadCount);
            aVar.f54195h.setVisibility(0);
        } else {
            aVar.f54195h.setVisibility(8);
        }
        SkinManager.setViewTextColor(aVar.f54192e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(aVar.f54193f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(aVar.f54194g, R.color.CAM_X0109, 1);
    }

    public void n(List<ImMessageCenterShowItemData> list) {
        if (this.f54186f == null) {
            this.f54186f = new LinkedList();
        }
        this.f54186f = list;
        notifyDataSetChanged();
    }

    public void o(boolean z) {
        this.f54187g = z;
    }

    public abstract BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str);
}
