package d.b.i0.d1.f.i;

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
import d.b.h0.s.d.d;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public abstract class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f53684e;

    /* renamed from: f  reason: collision with root package name */
    public List<ImMessageCenterShowItemData> f53685f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53686g = false;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public ImageView f53689c;

        /* renamed from: d  reason: collision with root package name */
        public BarImageView f53690d;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f53687a = null;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f53688b = null;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53691e = null;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53692f = null;

        /* renamed from: g  reason: collision with root package name */
        public TextView f53693g = null;

        /* renamed from: h  reason: collision with root package name */
        public MessageRedDotView f53694h = null;
        public View i = null;
        public ImageView j = null;
        public ImageView k = null;
        public ImageView l = null;

        public a(c cVar) {
        }
    }

    public c(Context context) {
        this.f53684e = null;
        this.f53684e = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        List<ImMessageCenterShowItemData> list = this.f53685f;
        if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.f53685f.get(i);
    }

    public a b(View view) {
        a aVar = new a(this);
        aVar.f53687a = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.f53689c = (ImageView) view.findViewById(R.id.svg_head);
        aVar.f53688b = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.f53690d = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.f53691e = (TextView) view.findViewById(R.id.chat_name);
        aVar.f53692f = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.f53693g = (TextView) view.findViewById(R.id.chat_time);
        aVar.i = view.findViewById(R.id.line);
        MessageRedDotView messageRedDotView = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.f53694h = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
        aVar.j = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.k = (ImageView) view.findViewById(R.id.send_status);
        aVar.l = (ImageView) view.findViewById(R.id.select_status);
        aVar.f53688b.setPlaceHolder(1);
        return aVar;
    }

    public boolean c() {
        return this.f53686g;
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
        List<ImMessageCenterShowItemData> list = this.f53685f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = view != null ? (a) view.getTag() : null;
        if (aVar == null) {
            view = LayoutInflater.from(this.f53684e).inflate(R.layout.chat_list_item, viewGroup, false);
            aVar = b(view);
            view.setTag(aVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
        SkinManager.setBackgroundResource(aVar.i, R.color.CAM_X0205);
        aVar.f53687a.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
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
            aVar.f53692f.setText("");
        } else {
            aVar.f53692f.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return;
        }
        aVar.f53691e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.f53686g) {
            aVar.l.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_s);
                SkinManager.setBackgroundColor(aVar.f53687a, R.color.CAM_X0205);
                return;
            }
            SkinManager.setBackgroundResource(aVar.l, R.drawable.btn_bgb_choice_n);
            SkinManager.setBackgroundColor(aVar.f53687a, R.color.CAM_X0205);
            return;
        }
        aVar.l.setVisibility(8);
        TBSelector.setViewBackgroundColorWithPressedState(aVar.f53687a, R.color.CAM_X0205, R.color.CAM_X0204);
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
        aVar.f53693g.setText(imMessageCenterShowItemData.getServerTime() != 0 ? StringHelper.getChatTimeString(date) : "");
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.d().e() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair p = p(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (p != null && p.getName() != null && p.getName().length() > 0) {
                    unReadCount = d.b.b.e.m.b.d(p.getName(), 0);
                }
            }
            aVar.f53694h.setThreeDotMode(2);
            aVar.f53694h.f(unReadCount);
            aVar.f53694h.setVisibility(0);
        } else {
            aVar.f53694h.setVisibility(8);
        }
        SkinManager.setViewTextColor(aVar.f53691e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(aVar.f53692f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(aVar.f53693g, R.color.CAM_X0109, 1);
    }

    public void n(List<ImMessageCenterShowItemData> list) {
        if (this.f53685f == null) {
            this.f53685f = new LinkedList();
        }
        this.f53685f = list;
        notifyDataSetChanged();
    }

    public void o(boolean z) {
        this.f53686g = z;
    }

    public abstract BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);
}
