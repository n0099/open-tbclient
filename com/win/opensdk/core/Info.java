package com.win.opensdk.core;

import android.text.TextUtils;
import android.util.SparseArray;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class Info implements Serializable {
    public String btndesc;
    public int cache;
    public int cb;
    public int cdt;
    public String click_urls;
    public long countdown;
    public String desc;
    public String dl_name;
    public String dl_pkg;
    public int dl_vsc;
    public String dpl;
    public String events;

    /* renamed from: h  reason: collision with root package name */
    public int f40203h;
    public boolean ho_c_sw;
    public String icon;
    public String id;
    public String image;
    public String imp_urls;
    public boolean isShown;
    public long lo_timeout;
    public String load;
    public String load_type;
    public boolean nat;
    public String open;
    public int opent;
    public String oph5Url;
    public String pid;
    public int ps;
    public double sper;
    public long spet;
    public String title;
    public String traceid;
    public int tsi;
    public int type;
    public String vv_click_urls;
    public String vv_downf_urls;
    public String vv_downs_urls;
    public String vv_finish_urls;
    public String vv_ins_urls;
    public String vv_show_urls;
    public String vv_start_urls;
    public long vvamount;
    public int vvt;
    public int w;
    public int wt;
    public int xn;
    public boolean vertical = true;
    public long ctt = System.currentTimeMillis();

    public String getBtndesc() {
        return this.btndesc;
    }

    public int getCache() {
        return this.cache;
    }

    public int getCb() {
        return this.cb;
    }

    public int getCdt() {
        return this.cdt;
    }

    public String getClick_urls() {
        return this.click_urls;
    }

    public long getCountdown() {
        return this.countdown;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDl_name() {
        return this.dl_name;
    }

    public String getDl_pkg() {
        return this.dl_pkg;
    }

    public int getDl_vsc() {
        return this.dl_vsc;
    }

    public String getDpl() {
        return this.dpl;
    }

    public SparseArray getEvents() {
        SparseArray sparseArray = new SparseArray();
        if (!TextUtils.isEmpty(this.events)) {
            try {
                JSONArray jSONArray = new JSONArray(this.events);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        sparseArray.put(optJSONObject.optInt("type", 0), optJSONObject.optString("urls"));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return sparseArray;
    }

    public int getH() {
        return this.f40203h;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public String getImp_urls() {
        return this.imp_urls;
    }

    public long getLo_timeout() {
        return this.lo_timeout;
    }

    public String getLoad() {
        return this.load;
    }

    public String getLoad_type() {
        return this.load_type;
    }

    public String getOpen() {
        return this.open;
    }

    public int getOpent() {
        return this.opent;
    }

    public String getOph5Url() {
        return this.oph5Url;
    }

    public String getPid() {
        return this.pid;
    }

    public int getPs() {
        return this.ps;
    }

    public double getSper() {
        return this.sper;
    }

    public long getSpet() {
        return this.spet;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTraceid() {
        return this.traceid;
    }

    public int getTsi() {
        return this.tsi;
    }

    public int getType() {
        return this.type;
    }

    public String getVv_click_urls() {
        return this.vv_click_urls;
    }

    public String getVv_downf_urls() {
        return this.vv_downf_urls;
    }

    public String getVv_downs_urls() {
        return this.vv_downs_urls;
    }

    public String getVv_finish_urls() {
        return this.vv_finish_urls;
    }

    public String getVv_ins_urls() {
        return this.vv_ins_urls;
    }

    public String getVv_show_urls() {
        return this.vv_show_urls;
    }

    public String getVv_start_urls() {
        return this.vv_start_urls;
    }

    public long getVvamount() {
        return this.vvamount;
    }

    public int getVvt() {
        return this.vvt;
    }

    public int getW() {
        return this.w;
    }

    public int getWt() {
        return this.wt;
    }

    public int getXn() {
        return this.xn;
    }

    public boolean isEffective() {
        return System.currentTimeMillis() - this.ctt <= ((long) (getCache() * 1000));
    }

    public boolean isHo_c_sw() {
        return this.ho_c_sw;
    }

    public boolean isNat() {
        return this.nat;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public boolean isVertical() {
        return this.vertical;
    }

    public void setBtndesc(String str) {
        this.btndesc = str;
    }

    public void setCache(int i) {
        this.cache = i;
    }

    public void setCb(int i) {
        this.cb = i;
    }

    public void setCdt(int i) {
        this.cdt = i;
    }

    public void setClick_urls(String str) {
        this.click_urls = str;
    }

    public void setCountdown(long j) {
        this.countdown = j;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDl_name(String str) {
        this.dl_name = str;
    }

    public void setDl_pkg(String str) {
        this.dl_pkg = str;
    }

    public void setDl_vsc(int i) {
        this.dl_vsc = i;
    }

    public void setDpl(String str) {
        this.dpl = str;
    }

    public void setEvents(String str) {
        this.events = str;
    }

    public void setH(int i) {
        this.f40203h = i;
    }

    public void setHo_c_sw(boolean z) {
        this.ho_c_sw = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setImp_urls(String str) {
        this.imp_urls = str;
    }

    public void setLo_timeout(long j) {
        this.lo_timeout = j;
    }

    public void setLoad(String str) {
        this.load = str;
    }

    public void setLoad_type(String str) {
        this.load_type = str;
    }

    public void setNat(boolean z) {
        this.nat = z;
    }

    public void setOpen(String str) {
        this.open = str;
    }

    public void setOpent(int i) {
        this.opent = i;
    }

    public void setOph5Url(String str) {
        this.oph5Url = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setSper(double d2) {
        this.sper = d2;
    }

    public void setSpet(long j) {
        this.spet = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTraceid(String str) {
        this.traceid = str;
    }

    public void setTsi(int i) {
        this.tsi = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVertical(boolean z) {
        this.vertical = z;
    }

    public void setVv_click_urls(String str) {
        this.vv_click_urls = str;
    }

    public void setVv_downf_urls(String str) {
        this.vv_downf_urls = str;
    }

    public void setVv_downs_urls(String str) {
        this.vv_downs_urls = str;
    }

    public void setVv_finish_urls(String str) {
        this.vv_finish_urls = str;
    }

    public void setVv_ins_urls(String str) {
        this.vv_ins_urls = str;
    }

    public void setVv_show_urls(String str) {
        this.vv_show_urls = str;
    }

    public void setVv_start_urls(String str) {
        this.vv_start_urls = str;
    }

    public void setVvamount(long j) {
        this.vvamount = j;
    }

    public void setVvt(int i) {
        this.vvt = i;
    }

    public void setW(int i) {
        this.w = i;
    }

    public void setWt(int i) {
        this.wt = i;
    }

    public void setXn(int i) {
        this.xn = i;
    }
}
