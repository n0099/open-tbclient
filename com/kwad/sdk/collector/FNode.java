package com.kwad.sdk.collector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.AppStatusHelper;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FNode implements Serializable, Comparable<FNode> {
    private static final String TAG = "FNode";
    private static HashSet<String> specialPath = new HashSet<>();
    private AppStatusHelper.AppRunningInfo appRunningInfo;
    private NodeFilter externalFilter;
    private FNode parent;
    private File realFile;
    private ArrayList<FNode> children = new ArrayList<>();
    private HashMap<String, Object> infoMap = new HashMap<>();
    private FChildNodeInfo nodeInfo = null;

    /* loaded from: classes4.dex */
    public static class FChildNodeInfo implements Serializable {
        private static final long serialVersionUID = 1544029961328446275L;
        private long totalSize;

        public void add(@NonNull FChildNodeInfo fChildNodeInfo) {
            this.totalSize += fChildNodeInfo.totalSize;
        }

        public long getTotalSize() {
            return this.totalSize;
        }

        public void setTotalSize(long j) {
            this.totalSize = j;
        }

        public String toString() {
            return "ChildrenInfo{totalSize=" + this.totalSize + '}';
        }
    }

    public FNode(@Nullable FNode fNode, File file) {
        this.parent = fNode;
        this.realFile = file;
    }

    public static boolean isAllMatchPath(FNode fNode) {
        if (fNode == null || fNode.getNodePath() == null) {
            return false;
        }
        return specialPath.contains(fNode.getNodeFileName());
    }

    private boolean onFilterChild(File file) {
        if (file == null || !file.exists() || file.lastModified() > System.currentTimeMillis() + 300000) {
            return false;
        }
        if (this.externalFilter != null) {
            return this.externalFilter.onFilterChild(file);
        }
        return true;
    }

    private void readNodeInfo() {
        File file = this.realFile;
        this.infoMap.put("path", file.getAbsolutePath());
        this.infoMap.put("lastModified", Long.valueOf(file.lastModified()));
        this.infoMap.put("fileSize", Long.valueOf(file.isFile() ? file.length() : -1L));
    }

    private void sortChildren(List<FNode> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FNode fNode) {
        return getRealFile().getName().compareTo(fNode.getRealFile().getName());
    }

    public List<String> dumpNode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(toString());
        if (this.children != null && this.children.size() > 0) {
            Iterator<FNode> it = this.children.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().dumpNode());
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.realFile.getAbsolutePath().equals(((FNode) obj).realFile.getAbsolutePath());
    }

    @Nullable
    public AppStatusHelper.AppRunningInfo getAppRunningInfo() {
        if (this.appRunningInfo != null) {
            return this.appRunningInfo;
        }
        if (this.parent != null) {
            return this.parent.getAppRunningInfo();
        }
        return null;
    }

    public List<FNode> getChildren() {
        return this.children;
    }

    public NodeFilter getExternalFilter() {
        return this.externalFilter;
    }

    public FChildNodeInfo getFNodeInfo() {
        return this.nodeInfo;
    }

    @Nullable
    public String getNodeFileName() {
        if (this.realFile == null || !this.realFile.exists()) {
            return null;
        }
        return this.realFile.getName();
    }

    public long getNodeLastModifyTime() {
        if (this.realFile == null || !this.realFile.exists()) {
            return -1L;
        }
        return this.realFile.lastModified();
    }

    @Nullable
    public String getNodePath() {
        if (this.realFile == null || !this.realFile.exists()) {
            return null;
        }
        return this.realFile.getAbsolutePath();
    }

    public FNode getParent() {
        return this.parent;
    }

    public File getRealFile() {
        return this.realFile;
    }

    public int hashCode() {
        return this.realFile.getAbsolutePath().hashCode();
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean nodeChange(FNode fNode) {
        String nodePath;
        if (fNode == null || (nodePath = fNode.getNodePath()) == null || getNodePath() == null || !nodePath.equals(getNodePath())) {
            return false;
        }
        if (getNodeLastModifyTime() == fNode.getNodeLastModifyTime()) {
            return this.children.size() != fNode.children.size();
        }
        return true;
    }

    public void readNode() {
        FChildNodeInfo fChildNodeInfo = new FChildNodeInfo();
        if (this.realFile.isFile()) {
            fChildNodeInfo.setTotalSize(this.realFile.length());
        } else {
            File[] listFiles = this.realFile.listFiles();
            if (listFiles == null) {
                fChildNodeInfo.setTotalSize(0L);
            } else {
                for (File file : listFiles) {
                    if (onFilterChild(file)) {
                        FNode fNode = new FNode(this, file);
                        fNode.readNodeInfo();
                        fNode.readNode();
                        FChildNodeInfo fNodeInfo = fNode.getFNodeInfo();
                        if (fNodeInfo != null) {
                            fChildNodeInfo.add(fNodeInfo);
                        }
                        if (this.externalFilter != null) {
                            this.externalFilter.onChildNodeCreate(fNode);
                        }
                        this.children.add(fNode);
                    }
                }
                sortChildren(this.children);
            }
        }
        this.nodeInfo = fChildNodeInfo;
    }

    public void setAppRunningInfo(AppStatusHelper.AppRunningInfo appRunningInfo) {
        this.appRunningInfo = appRunningInfo;
    }

    public void setExternalFilter(NodeFilter nodeFilter) {
        this.externalFilter = nodeFilter;
    }

    public void setFNodeInfo(FChildNodeInfo fChildNodeInfo) {
        this.nodeInfo = fChildNodeInfo;
    }

    public String toString() {
        return "FNode{realFile=" + this.realFile + ", nodeInfo=" + this.nodeInfo + '}';
    }
}
