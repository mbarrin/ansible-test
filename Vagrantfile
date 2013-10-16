# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.box = "precise64"

  config.vm.define "web" do |web|
    web.vm.network :private_network, ip: "192.168.111.10"
    web.vm.hostname = "web"
    web.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/site/webservers.yml"
      ansible.inventory_path = "provisioning/site/testing"
      ansible.verbose = true
    end
  end

  config.vm.define "api" do |api|
    api.vm.network :private_network, ip: "192.168.111.11"
    api.vm.hostname = "api"
    api.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/site/apiservers.yml"
      ansible.inventory_path = "provisioning/site/testing"
      ansible.verbose = true
    end
  end

  config.vm.define "proxy" do |proxy|
    proxy.vm.network :private_network, ip: "192.168.111.12"
    proxy.vm.hostname = "proxy"
    proxy.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/site/proxyservers.yml"
      ansible.inventory_path = "provisioning/site/testing"
      ansible.verbose = true
    end
  end

  config.vm.define "search" do |search|
    search.vm.network :private_network, ip: "192.168.111.13"
    search.vm.hostname = "search"
    search.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/site/searchservers.yml"
      ansible.inventory_path = "provisioning/site/testing"
      ansible.verbose = true
    end
  end

  config.vm.define "logstash" do |logstash|
    logstash.vm.network :private_network, ip: "192.168.111.14"
    logstash.vm.hostname = "logstash"
    logstash.vm.provision "ansible" do |ansible|
      ansible.playbook = "provisioning/site/logstashmaster.yml"
      ansible.inventory_path = "provisioning/site/testing"
      ansible.verbose = true
    end
  end

  config.vm.provider :virtualbox do |vb|
        vb.customize ["modifyvm", :id, "--memory", "1024"]
  end
end
