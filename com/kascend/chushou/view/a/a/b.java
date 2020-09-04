package com.kascend.chushou.view.a.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.games.utils.so.SoUtils;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String f;
    private boolean j;
    private com.kascend.chushou.view.a.a<ListItem> nJs;
    private com.kascend.chushou.view.a.a<PannelItem> nXE;
    private final List<Object> c = new ArrayList();
    private boolean g = true;
    private boolean h = false;
    private boolean i = false;
    public boolean b = false;
    HashMap<PannelItem, Integer> a = new HashMap<>();

    public static int a(int i, int i2) {
        switch (i) {
            case 22:
                return i2 / 2;
            default:
                return i2;
        }
    }

    public b(String str, com.kascend.chushou.view.a.a<PannelItem> aVar, com.kascend.chushou.view.a.a<ListItem> aVar2, boolean z) {
        this.j = false;
        this.f = str;
        this.nXE = new com.kascend.chushou.view.a.b(aVar);
        this.nJs = new com.kascend.chushou.view.a.b(aVar2);
        this.j = z;
    }

    public void a(List<PannelItem> list) {
        this.c.clear();
        b(list);
        this.g = true;
    }

    private void b(List<PannelItem> list) {
        this.b = false;
        this.a.clear();
        a(true);
        if (!h.isEmpty(list)) {
            for (PannelItem pannelItem : list) {
                if (!h.isEmpty(pannelItem.mNavItemList)) {
                    String str = pannelItem.mNavItemList.get(0).mDisplayStyle;
                    if (!h.isEmpty(pannelItem.mDisplayName)) {
                        PannelItem copyAsHeader = pannelItem.copyAsHeader();
                        copyAsHeader.mType = "HEADER";
                        this.c.add(copyAsHeader);
                    }
                    if ("4".equals(str) && pannelItem != null && !h.isEmpty(pannelItem.mNavItemList)) {
                        int i = 0;
                        while (true) {
                            if (i >= pannelItem.mNavItemList.size()) {
                                break;
                            }
                            ListItem listItem = pannelItem.mNavItemList.get(i);
                            if (!PayHelper.STATUS_SUCC.equals(listItem.mType) || listItem.mAdExtraInfo == null || com.kascend.chushou.a.a.y != h.parseInt(listItem.mAdExtraInfo.mMarketId)) {
                                i++;
                            } else {
                                this.b = true;
                                break;
                            }
                        }
                    }
                    if ("4".equals(str) || Constants.VIA_REPORT_TYPE_JOININ_GROUP.equals(str) || Constants.VIA_REPORT_TYPE_DATALINE.equals(str) || SoUtils.SO_EVENT_ID_DEFAULT.equals(str) || "27".equals(str) || "10".equals(str) || "32".equals(str) || "12".equals(str)) {
                        pannelItem.mType = null;
                        this.c.add(pannelItem);
                    } else {
                        this.c.addAll(pannelItem.mNavItemList);
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return 22;
        }
        Object obj = this.c.get(i);
        if (obj instanceof PannelItem) {
            String str = ((PannelItem) obj).mNavItemList.get(0).mDisplayStyle;
            if (SoUtils.SO_EVENT_ID_DEFAULT.equals(str)) {
                return 5;
            }
            return (!"10".equals(str) && "32".equals(str)) ? 34 : 6;
        }
        if ((obj instanceof ListItem) && !"1".equals(((ListItem) obj).mDisplayStyle)) {
            return 22;
        }
        return 22;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 5:
                return new d(from.inflate(a.h.item_listitem_sliding_item_list, viewGroup, false), this.f);
            case 6:
                return new e(from.inflate(a.h.item_listitem_sliding_small_poster, viewGroup, false), this.f, "10");
            case 22:
                return new a(from.inflate(a.h.item_listitem_double_room_home, viewGroup, false), this.nJs, this.j ? false : true, this.f);
            case 34:
                return new e(from.inflate(a.h.item_listitem_sliding_small_poster, viewGroup, false), this.f, "32");
            default:
                return null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        if (list != null && list.size() > 0) {
            if (String.valueOf(list.get(0)).equals(TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE)) {
            }
        } else {
            onBindViewHolder(viewHolder, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        Object obj = this.c.get(i);
        if (!(obj instanceof Integer)) {
            if (obj instanceof PannelItem) {
                PannelItem pannelItem = (PannelItem) obj;
                switch (itemViewType) {
                    case 5:
                        ((d) viewHolder).a(pannelItem);
                        return;
                    case 6:
                    case 34:
                        ((e) viewHolder).a(pannelItem, Np(i));
                        return;
                    default:
                        return;
                }
            } else if (obj instanceof ListItem) {
                ListItem listItem = (ListItem) obj;
                switch (itemViewType) {
                    case 22:
                        ((a) viewHolder).a(listItem);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public void a(boolean z) {
        this.h = z;
    }

    public int bx(Object obj) {
        if (this.c != null) {
            return this.c.indexOf(obj);
        }
        return -1;
    }

    private int[] Np(int i) {
        int i2;
        if (i - 1 >= 0) {
            i2 = 0;
        } else {
            i2 = this.g ? 10 : 0;
        }
        return new int[]{i2, 0};
    }

    public void a(int i, int i2, ArrayList<ListItem> arrayList) {
        int i3 = (i2 - i) + 1;
        if (this.c != null && this.c.get(i) != null && this.c.get(i2) != null && arrayList.size() == i3) {
            this.c.subList(i, i2 + 1).clear();
            this.c.addAll(i, arrayList);
            notifyItemRangeChanged(i, i3);
        }
    }
}
