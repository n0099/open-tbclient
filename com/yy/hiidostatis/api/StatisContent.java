package com.yy.hiidostatis.api;

import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.StringUtil;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class StatisContent extends BaseStatisContent {
    public static AtomicInteger TMP_START_ID = new AtomicInteger(0);
    public String mAct;
    public long mAutoId;
    public int mCrepid;
    public String mGuid;
    public boolean fillCommon = true;
    public boolean fillConcrete = true;
    public boolean isCover = true;
    public boolean notSave = false;
    public Priority priority = Priority.PRIORITY_NORMAL;
    public int tmpId = TMP_START_ID.incrementAndGet();

    /* loaded from: classes9.dex */
    public enum Priority {
        PRIORITY_HIGH,
        PRIORITY_NORMAL,
        PRIORITY_LOW
    }

    public StatisContent() {
        setGuid(createGuid());
    }

    public static String createGuid() {
        return StringUtil.geneGuid();
    }

    public String getAct() {
        return this.mAct;
    }

    public long getAutoId() {
        return this.mAutoId;
    }

    public int getCrepid() {
        return this.mCrepid;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public int getTmpId() {
        return this.tmpId;
    }

    public boolean isCover() {
        return this.isCover;
    }

    public boolean isFillCommon() {
        return this.fillCommon;
    }

    public boolean isFillConcrete() {
        return this.fillConcrete;
    }

    public boolean isNotSave() {
        return this.notSave;
    }

    public StatisContent(String str) {
        this.mAct = str;
        setGuid(createGuid());
    }

    public void setAct(String str) {
        this.mAct = str;
    }

    public void setAutoId(long j) {
        this.mAutoId = j;
    }

    public void setCover(boolean z) {
        this.isCover = z;
    }

    public void setCrepid(int i) {
        this.mCrepid = i;
    }

    public void setFillCommon(boolean z) {
        this.fillCommon = z;
    }

    public void setFillConcrete(boolean z) {
        this.fillConcrete = z;
    }

    public void setGuid(String str) {
        this.mGuid = str;
        put(BaseStatisContent.GUID, str);
    }

    public void setNotSave(boolean z) {
        this.notSave = z;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.inner.BaseStatisContent
    public StatisContent copy() {
        StatisContent statisContent = new StatisContent();
        TreeMap<String, String> treeMap = new TreeMap<>(BaseStatisContent.COMPARATOR);
        statisContent.raw = treeMap;
        treeMap.putAll(this.raw);
        statisContent.setAct(this.mAct);
        statisContent.setAutoId(this.mAutoId);
        statisContent.setCover(this.isCover);
        statisContent.setCrepid(this.mCrepid);
        statisContent.setFillCommon(this.fillCommon);
        statisContent.setFillConcrete(this.fillConcrete);
        statisContent.setNotSave(this.notSave);
        statisContent.setPriority(this.priority);
        statisContent.setGuid(this.mGuid);
        return statisContent;
    }

    public StatisContent copyByNewGuid() {
        StatisContent statisContent = new StatisContent();
        TreeMap<String, String> treeMap = new TreeMap<>(BaseStatisContent.COMPARATOR);
        statisContent.raw = treeMap;
        treeMap.putAll(this.raw);
        statisContent.setAct(this.mAct);
        statisContent.setAutoId(this.mAutoId);
        statisContent.setCover(this.isCover);
        statisContent.setCrepid(this.mCrepid);
        statisContent.setFillCommon(this.fillCommon);
        statisContent.setFillConcrete(this.fillConcrete);
        statisContent.setNotSave(this.notSave);
        statisContent.setPriority(this.priority);
        return statisContent;
    }

    public void putContent(StatisContent statisContent, boolean z) {
        super.putContent((BaseStatisContent) statisContent, z);
    }
}
