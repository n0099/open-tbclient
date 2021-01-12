package com.win.opensdk.core;

import android.text.TextUtils;
import android.util.SparseArray;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Info implements Serializable {
    private String btndesc;
    private int cache;
    private int cb;
    private int cdt;
    private String click_urls;
    private long countdown;
    private String desc;
    private String dl_name;
    private String dl_pkg;
    private int dl_vsc;
    private String dpl;
    private String events;
    private int h;
    private String icon;
    private String id;
    private String imp_urls;
    private boolean isShown;
    private long lo_timeout;
    private String load;
    private String load_type;
    private boolean nat;
    private String open;
    private int opent;
    private String oph5Url;
    private String pid;
    private int ps;
    private double sper;
    private long spet;
    private String title;
    private String traceid;
    private int tsi;
    private int type;
    private String vv_click_urls;
    private String vv_downf_urls;
    private String vv_downs_urls;
    private String vv_finish_urls;
    private String vv_ins_urls;
    private String vv_show_urls;
    private String vv_start_urls;
    private long vvamount;
    private int vvt;
    private int w;
    private int wt;
    private int xn;
    private boolean vertical = true;
    private long ctt = System.currentTimeMillis();

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public String getLoad() {
        return this.load;
    }

    public String getLoad_type() {
        return this.load_type;
    }

    public String getOph5Url() {
        return this.oph5Url;
    }

    public void setOph5Url(String str) {
        this.oph5Url = str;
    }

    public void setLoad_type(String str) {
        this.load_type = str;
    }

    public double getSper() {
        return this.sper;
    }

    public void setSper(double d) {
        this.sper = d;
    }

    public long getSpet() {
        return this.spet;
    }

    public void setSpet(long j) {
        this.spet = j;
    }

    public int getDl_vsc() {
        return this.dl_vsc;
    }

    public long getVvamount() {
        return this.vvamount;
    }

    public void setVvamount(long j) {
        this.vvamount = j;
    }

    public int getVvt() {
        return this.vvt;
    }

    public void setVvt(int i) {
        this.vvt = i;
    }

    public int getOpent() {
        return this.opent;
    }

    public void setOpent(int i) {
        this.opent = i;
    }

    public void setDl_vsc(int i) {
        this.dl_vsc = i;
    }

    public String getDpl() {
        return this.dpl;
    }

    public void setDpl(String str) {
        this.dpl = str;
    }

    public String getDl_name() {
        return this.dl_name;
    }

    public void setDl_name(String str) {
        this.dl_name = str;
    }

    public String getDl_pkg() {
        return this.dl_pkg;
    }

    public void setDl_pkg(String str) {
        this.dl_pkg = str;
    }

    public void setLoad(String str) {
        this.load = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getCdt() {
        return this.cdt;
    }

    public void setCdt(int i) {
        this.cdt = i;
    }

    public int getCb() {
        return this.cb;
    }

    public void setCb(int i) {
        this.cb = i;
    }

    public int getCache() {
        return this.cache;
    }

    public void setCache(int i) {
        this.cache = i;
    }

    public int getWt() {
        return this.wt;
    }

    public void setWt(int i) {
        this.wt = i;
    }

    public int getXn() {
        return this.xn;
    }

    public void setXn(int i) {
        this.xn = i;
    }

    public int getTsi() {
        return this.tsi;
    }

    public void setTsi(int i) {
        this.tsi = i;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String str) {
        this.open = str;
    }

    public String getTraceid() {
        return this.traceid;
    }

    public void setTraceid(String str) {
        this.traceid = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getBtndesc() {
        return this.btndesc;
    }

    public void setBtndesc(String str) {
        this.btndesc = str;
    }

    public String getImp_urls() {
        return this.imp_urls;
    }

    public void setImp_urls(String str) {
        this.imp_urls = str;
    }

    public String getClick_urls() {
        return this.click_urls;
    }

    public void setClick_urls(String str) {
        this.click_urls = str;
    }

    public String getVv_show_urls() {
        return this.vv_show_urls;
    }

    public void setVv_show_urls(String str) {
        this.vv_show_urls = str;
    }

    public String getVv_click_urls() {
        return this.vv_click_urls;
    }

    public void setVv_click_urls(String str) {
        this.vv_click_urls = str;
    }

    public String getVv_start_urls() {
        return this.vv_start_urls;
    }

    public void setVv_start_urls(String str) {
        this.vv_start_urls = str;
    }

    public String getVv_finish_urls() {
        return this.vv_finish_urls;
    }

    public void setVv_finish_urls(String str) {
        this.vv_finish_urls = str;
    }

    public String getVv_downs_urls() {
        return this.vv_downs_urls;
    }

    public void setVv_downs_urls(String str) {
        this.vv_downs_urls = str;
    }

    public String getVv_downf_urls() {
        return this.vv_downf_urls;
    }

    public void setVv_downf_urls(String str) {
        this.vv_downf_urls = str;
    }

    public String getVv_ins_urls() {
        return this.vv_ins_urls;
    }

    public void setVv_ins_urls(String str) {
        this.vv_ins_urls = str;
    }

    public boolean isEffective() {
        return System.currentTimeMillis() - this.ctt <= ((long) (getCache() * 1000));
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public boolean isNat() {
        return this.nat;
    }

    public void setNat(boolean z) {
        this.nat = z;
    }

    public boolean isVertical() {
        return this.vertical;
    }

    public void setVertical(boolean z) {
        this.vertical = z;
    }

    public int getPs() {
        return this.ps;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public int getW() {
        return this.w;
    }

    public void setW(int i) {
        this.w = i;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int i) {
        this.h = i;
    }

    public long getCountdown() {
        return this.countdown;
    }

    public void setCountdown(long j) {
        this.countdown = j;
    }

    public long getLo_timeout() {
        return this.lo_timeout;
    }

    public void setLo_timeout(long j) {
        this.lo_timeout = j;
    }

    public SparseArray<String> getEvents() {
        SparseArray<String> sparseArray = new SparseArray<>();
        if (!TextUtils.isEmpty(this.events)) {
            try {
                JSONArray jSONArray = new JSONArray(this.events);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        sparseArray.put(optJSONObject.optInt("type", 0), optJSONObject.optString("urls"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sparseArray;
    }

    public void setEvents(String str) {
        this.events = str;
    }
}
