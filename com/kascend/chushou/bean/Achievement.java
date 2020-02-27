package com.kascend.chushou.bean;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public class Achievement implements Serializable {
    public Detail detailItem;
    public List<Medal> medalList;
    public int starCount;
    public int totalCount;

    /* loaded from: classes5.dex */
    public static class Detail implements Serializable {
        public String name;
        public int type;
    }

    /* loaded from: classes5.dex */
    public static class Medal implements Serializable {
        public String desc;
        public String icon;
        public String name;
        public int type;
    }
}
